package com.smsm.controller.newoptioncontroller;

import com.smsm.enumvalue.STATE;
import com.smsm.model.Company;
import com.smsm.model.JobSeeker;
import com.smsm.model.User;
import com.smsm.service.CompanyService;
import com.smsm.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private CompanyService companyService;


    static Logger log = Logger.getLogger(LoginController.class);


    @RequestMapping("/login")
    public Map<String, Object> userLogin(User user, HttpServletRequest request,
                                         HttpServletResponse response, Model model) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        HttpSession session = request.getSession();
        //数据库查询
        log.info("进入登录接口。。。。");
        User user1 = null;
        Company company = null;

        try {
            user1 = userService.findUserInfo(user.getUserPhone());
            if (user1 == null) {//用户不存在
                map.put("state", STATE.USER_NOT_EXIT);
                map.put("msg", "用户不存在，请先注册！");
            } else {//用户存在
                if (user.getUserPwd().equals(user1.getUserPwd())) {//密码正确
                    if (user1.getUserType().equals("company")){
                        company = companyService.getCompanyByUserPhone(user.getUserPhone());
                        if (company == null){//公司信息未完善
                            user.setCompanyId("");
                            map.put("company",false);
                        }else {//公司信息完善
                            log.info(company.toString());
                            user.setCompanyId(company.getCompanyId());
                            map.put("company",true);
                        }
                    }
                    map.put("state", STATE.SUCCESS);
                    map.put("msg", "验证成功！");
                    session.setAttribute("user",user1);
                } else {//密码错误
                    map.put("state", STATE.PWD_ERROR);
                    map.put("msg", "密码错误！");
                }
            }
        } catch (Exception e) {//数据库异常
            e.printStackTrace();
            map.put("state", STATE.SQL_EXCEPTION);
            map.put("msg", "数据库异常！");
        }
        return map;
    }

    @RequestMapping("/register")
    public Map<String,Object> userRegister(User user, Model model,
                                           HttpServletRequest request){
        HttpSession session = request.getSession();
        HashMap<String,Object> map = new HashMap<String, Object>();
        //判断手机号是否已经注册
        User userIsExit = userService.findUserInfo(user.getUserPhone());
        log.info("进入用户注册接口.....");
        if(userIsExit!=null){//手机号已经被注册
            log.info(user.getUserPhone()+"已存在");
            map.put("state",STATE.USER_EXIT);
            map.put("msg","手机号已经注册，请直接登录！");
        }else {//手机号未注册
            log.info("userName:"+user.getUserName());
            if (user.getUserName().equals("")){
                user.setUserName("用户"+user.getUserPhone());
            }
            try {
                int flag = userService.insertUserInfo(user);
                if (flag == 1){//插入成功
                    log.info("用户注册成功！"+user.getUserPhone());
                    map.put("state",STATE.SUCCESS);
                    User current = userService.findUserInfo(user.getUserPhone());
                    if(user.getUserType().equals("personal")){
                        JobSeeker jobSeeker = new JobSeeker();
                        jobSeeker.setJobSeekerName(current.getUserName());
                        jobSeeker.setUserId(current.getUserId());
                        if(userService.insertJobSeeker(jobSeeker) == 1)
                            log.info("求职者信息更新成功");
                        else
                            log.info("求职者信息更新失败");
                    }
                    session.setAttribute("user", current);
                }else {//插入失败
                    map.put("state",STATE.SQL_FAILURE);
                    map.put("msg","数据库忙，请稍后重试！");
                }
            }catch (Exception e){//数据库异常
                log.info(e.getMessage());
                map.put("state", STATE.SQL_EXCEPTION);
                map.put("msg", "数据库繁忙！请稍后重试");
            }
        }

        return map;
    }

    @RequestMapping("/logout")
    public Map<String,Object> logout(HttpServletRequest request){
        HttpSession session = request.getSession();
        Map<String,Object> map = new HashMap<String, Object>();
        try {
            session.invalidate();
            log.info("用户退出登陆。。清除会话");
            map.put("state",STATE.SUCCESS);
            map.put("msg","退出登陆成功！");
        }catch (Exception e){
            log.info("退出登陆失败！");
            map.put("state",STATE.FAILURE);
            map.put("msg","退出登陆失败，请重试！");
        }

        return map;
    }

    @RequestMapping("/updatePwd")
    public Map<String,Object> updatePwd(HttpServletRequest request,String newPwd,String oldPwd){
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        Map<String,Object> map = new HashMap<>();
        log.info("进入修改密码的接口");
        if (oldPwd.equals(user.getUserPwd())){
            try {
                user.setUserPwd(newPwd);
                int flag = userService.updatePwd(user);
                if (flag == 1){
                    log.info("修改成功");
                    logout(request);
                    map.put("state",STATE.SUCCESS);
                }else {
                    log.info("修改失败");
                    map.put("state",STATE.FAILURE);
                    map.put("msg","修改失败，请重试");
                }
            }catch (Exception e){
                log.info("出现异常");
                e.printStackTrace();
                map.put("state",STATE.SQL_EXCEPTION);
                map.put("msg","数据库繁忙，请重试");
            }
        }else {
            log.info("当前密码输入错误");
            map.put("state",STATE.PWD_ERROR);
            map.put("msg","密码输入错误，请重试");
        }
        return map;
    }
}
