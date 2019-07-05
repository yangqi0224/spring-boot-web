package com.smsm.controller.newoptioncontroller;

import com.smsm.enumvalue.STATE;
import com.smsm.model.*;
import com.smsm.service.*;
import com.smsm.util.AlertSet;
import com.smsm.util.DetailDeal;
import org.apache.log4j.Category;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;

@RequestMapping("/company")
@Controller
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @Autowired
    private RecruitmentService recruitmentService;

    @Autowired
    private ResumeService resumeService;

    @Autowired
    private ToEmployService toEmployService;

    static Logger log = Logger.getLogger(CompanyController.class);

    @RequestMapping("/findCompany")
    public ModelAndView findCompany(Model model){

        log.info("进入查找所有公司信息的接口......");
        List<Company> companyList = new ArrayList<Company>();
        List<Recruitment> recruitmentList = new ArrayList<Recruitment>();

        companyList = companyService.findAllCompany();

        model.addAttribute("list",companyList);

        for(Company list :companyList){
            log.info(list.getCompanyLocation());
            log.info(list.getCompanyField());
            recruitmentList=recruitmentService.selectRecByCompanyId(list.getCompanyId());
            list.setRecruitments(recruitmentList);
        }
        return new ModelAndView("companylist");
    }

    @RequestMapping("/findJob")
   // @ResponseBody
    public String findJob(@RequestParam("createTime")String createTime,Model model,HttpSession session){
        log.info("进入查看招聘信息的接口......");
        User user = (User)session.getAttribute("user");
        Recruitment c = recruitmentService.selectRecruitById(createTime);
        c.setCompany(companyService.selectCompanyById(c.getCompanyId()));
        log.info(c.getCompany());
        System.out.println(createTime);
        //log.info("内容：："+c.getJobDesc()+"======"+c.getJobName());
        if (c.getJobCondition()!=null)
            c.setConList(DetailDeal.deal(c.getJobCondition()));
        if (c.getJobDesc()!=null)
            c.setDescList(DetailDeal.deal(c.getJobDesc()));
        model.addAttribute("job",c);
        //System.out.println("=====公司名称====="+c.getCompanyName());
        return "/jobdetail";
    }


    @RequestMapping("/getCompanyInfo")
    @ResponseBody
    public Map<String,Object> getCompany(HttpSession session){
        log.info("进入获取公司信息的接口....");
        Map<String,Object> map = new HashMap<>();
        User user = (User)session.getAttribute("user");
        Company company = companyService.getCompanyByUserPhone(user.getUserPhone());
        log.info(company);
        map.put("company",company);
        return map;
    }

    @RequestMapping("/updateCompanyInfo")
    @ResponseBody
    public Map<String,Object> updateCompany(Company company, HttpSession session){
        log.info("进入新增、更新公司信息的接口......\n"+
                company.toString());
        Map<String,Object> map = new HashMap<>();
        User user = (User)session.getAttribute("user");
        try {
            int flag;
            if (user.getCompanyId()==null){
                company.setUserPhone(user.getUserPhone());
                log.info(company.toString());
                flag = companyService.insertCompanyInfo(company);
            }
            else {
                company.setCompanyId(user.getCompanyId());
                flag = companyService.updateCompanyInfo(company);
            }

            if (flag == 1){
                log.info("新增/更新公司信息成功");
                map.put("state", STATE.SUCCESS);
                map.put("msg","操作成功");
                user.setCompanyId(companyService.getCompanyByUserPhone(user.getUserPhone()).getCompanyId());
                //log.info(user.getCompany().toString());
                map.put("company",companyService.getCompanyByUserPhone(user.getUserPhone()));
                session.setAttribute("user",user);
            }else {
                log.info("新增/更新公司信息失败");
                map.put("state",STATE.FAILURE);
                map.put("msg","操作失败，请重试！");
            }
        }catch (Exception e){
            log.info("数据库异常！");
            log.info(e);
            e.printStackTrace();
            map.put("state",STATE.SQL_EXCEPTION);
            map.put("msg","数据库繁忙，请重试！");
        }
        return map;
    }

    @RequestMapping("/insertRec")
    @ResponseBody
    public Map<String,Object> createRec(Recruitment recruitment,HttpSession session){
        log.info("进入发布招聘信息的接口....\n"+recruitment.toString());
        Map<String,Object> map = new HashMap<>();
        User user = (User)session.getAttribute("user");

        recruitment.setJobSalary(recruitment.getSalaryMin()+"k-"+recruitment.getSalaryMax()+'k');
        Job job = null;
        try {
            job = recruitmentService.selectJobByRec(recruitment);
            if (job == null){
                recruitmentService.insertJobByRec(recruitment);
                job = recruitmentService.selectJobByRec(recruitment);
            }
            log.info("job detail is:"+job.toString());
            int flag = recruitmentService.insertRecruit(recruitment);
            if (flag == 1){
                log.info("发布成功");
                map.put("state",STATE.SUCCESS);
            }else {
                log.info("发布失败");
                map.put("state",STATE.FAILURE);
                map.put("msg","发布招聘信息失败");
            }
        }catch (Exception e){
            log.info("数据库异常");
            e.printStackTrace();
            map.put("state",STATE.SQL_EXCEPTION);
            map.put("msg","数据库繁忙，请稍后重试");
        }

        return map;
    }

    @RequestMapping("/recView")
    public String recView(int state,HttpSession session,Model model){

        log.info("进入查看公司招聘职位的接口......");
        User user = (User)session.getAttribute("user");
        List<Recruitment> list = null;
        try {
            list = recruitmentService.selectRecByCompanyId(user.getCompanyId());
            if (list != null){
                for (Recruitment r:list){
                    if (r.getState() == state || state == 2)
                        r.setNum(companyService.selectToEmployByRec(r.getRecruitmentId()).size());
                    else
                        list.remove(r);
                }
                log.info("查询成功\n"+list);
                model.addAttribute("list",list);
                model.addAttribute("flag",true);
            }else {
                log.info("您还没有发布招聘信息。");
                model.addAttribute("flag",false);
            }

        } catch (Exception e) {
            log.info("查询失败，数据库异常");
            e.printStackTrace();
        }
        return "positions";
    }

    @RequestMapping("/getToEmployResume")
    @ResponseBody
    public Map<String,Object> getToEmployResume(String recruitmentId,int state,HttpSession session){
        log.info("进入招聘者查看应聘简历的接口");
        Map<String,Object> map = new HashMap<>();
        User user = (User)session.getAttribute("user");
        Company company = null;
        List<Resume> resumes = new ArrayList<>();
        List<ToEmploy> toEmploys = null;
        try {
            log.info("recruitmentId:"+recruitmentId+" state:"+state);
            if (recruitmentId.equals("all")){
                company = companyService.getCompanyByUserPhone(user.getUserPhone());
                toEmploys = companyService.selectToEmployByCompany(company.getCompanyId());
                //int n = 0;
                //Iterator<ToEmploy> it = toEmploys.iterator();
                for (int i = toEmploys.size()-1;i>=0;i--){

                    if (toEmploys.get(i).getState()==state || state == 3){
                        log.info("add:"+toEmploys.get(i).getState());
                        resumes.add(resumeService.selectResumeById(toEmploys.get(i).getResumeId()));
                    }else {
                        log.info("remove:"+toEmploys.get(i).getState());
                        toEmploys.remove(i);
                    }
                }
            }else {
                toEmploys = companyService.selectToEmployByRec(recruitmentId);
                for (ToEmploy t:toEmploys){
                    resumes.add(resumeService.selectResumeById(t.getResumeId()));
                }
            }
            if (resumes!=null){
                for (ToEmploy t:toEmploys){
                    t.setRecruitment(recruitmentService.selectRecruitById(t.getRecruitmentId()));
                }
                log.info("查询成功\n"+resumes+"\n"+toEmploys);
                map.put("state",STATE.SUCCESS);
                map.put("list",resumes);
                map.put("toList",toEmploys);
            }else {
                log.info("查询成功，但是没有简历");
                map.put("state",STATE.SQL_SUCCESS);
                map.put("msg","尚无简历投递");
            }
        }catch (Exception e){
            log.info("数据库异常");
            e.printStackTrace();
            map.put("state",STATE.SQL_EXCEPTION);
            map.put("msg","数据库繁忙，请稍后重试");
        }
        return map;
    }

    @RequestMapping("/notifyJobSeeker")
    @ResponseBody
    public Map<String,Object> notifyJobSeeker(ToEmploy toEmploy, HttpServletResponse response, HttpServletRequest request){

        log.info("进入通知求职者求职结果的接口\n"+
                toEmploy.toString());

        int flag ;

        Map<String,Object> map = new HashMap<>();
        try {
            flag = toEmployService.updateToEmploy(toEmploy);

            if (flag == 1){
                log.info("通知成功");
                map.put("state",STATE.SUCCESS);

            }else {
                log.info("通知失败");
                map.put("state",STATE.FAILURE);
            }
        }catch (Exception e){
            e.printStackTrace();
            log.info("通知失败");
            map.put("state",STATE.SQL_EXCEPTION);
        }

        return map;
    }


}
