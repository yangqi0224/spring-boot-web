package com.smsm.controller.newoptioncontroller;


import com.smsm.enumvalue.STATE;
import com.smsm.mapper.ResumeMapper;
import com.smsm.model.*;
import com.smsm.service.*;
import com.smsm.util.DetailDeal;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.ResultSetMetaData;
import java.util.*;

@Controller
@RequestMapping("personal")
public class PersonalController {

    @Autowired
    private UserService userService;

    @Autowired
    private RecruitmentService recruitmentService;

    @Autowired
    private ResumeService resumeService;

    @Autowired
    private ToEmployService toEmployService;

    @Autowired
    private CompanyService companyService;

    static final Logger log = Logger.getLogger(PersonalController.class);

    @RequestMapping("/resume")
    public String getUserResume(Model model, HttpServletRequest request){

        log.info("进入查找个人简历的接口");

        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        log.info("userName:"+user.getUserName());

        Resume resume = new Resume();
        WorkHistory workHistory = new WorkHistory();
        if (userService.selectFirstResumeByUserId(user.getUserId()) != null) {
            resume = userService.selectFirstResumeByUserId(user.getUserId());
            resume.setProjectExps(resumeService.selectProExp(resume.getResumeId()));
            resume.setWorkHistories(resumeService.selectWorkHisByResume(resume.getResumeId()));
        }
        else {
            resume.setResumeName(user.getUserName()+"的简历");
            resume.setName(user.getUserName());
            resume.setPhone(user.getUserPhone());
            resume.setJobSeekerId(userService.
                    selectJobSeekerByUserId(user.getUserId()).getJobSeekerId());
            resumeService.insertUserInfo(resume);
        }

        session.setAttribute("resume",resume);
        //log.info(user.getUserPhone());
        model.addAttribute("resume",resume);
        return "/jianli";
    }

    /**
     * 查找个人简历
     * @param session
     * @return
     */
    @ResponseBody
    @RequestMapping("/getResume")
    public Map<String, Object> getResumeInfo(HttpSession session){
        log.info("进入查找个人简历的接口");
        Map<String,Object> map = new HashMap<>();
        User user = (User)session.getAttribute("user");
        Resume resume = new Resume();
        WorkHistory workHistory = new WorkHistory();
        log.info("UserName is "+user.getUserName()+" User Phone Is "+ user.getUserPhone());
        if (userService.selectFirstResumeByUserId(user.getUserId()) != null) {
            resume = userService.selectFirstResumeByUserId(user.getUserId());
            resume.setProjectExps(resumeService.selectProExp(resume.getResumeId()));
            resume.setWorkHistories(resumeService.selectWorkHisByResume(resume.getResumeId()));
            log.info(resume.toString());
        }
        else {//用户简历为空，创建一个简历
            resume.setResumeName(user.getUserName()+"的简历");
            resume.setName(user.getUserName());
            resume.setPhone(user.getUserPhone());
            resume.setJobSeekerId(userService.
                    selectJobSeekerByUserId(user.getUserId()).getJobSeekerId());
            resumeService.insertUserInfo(resume);
        }
        //resume.setWorkHistory(workHistory);
        //TODO session中放resumeId更好，而不是将整个resume对象放进去
        session.setAttribute("resume",resume);
        map.put("resume",resume);
        return map;
    }

    /**
     * 更新工作经验
     * @param workHistory
     * @param session
     * @return
     */
    @ResponseBody
    @RequestMapping("/addWorkHis")
    public Map<String,Object> updateWorkHis(WorkHistory workHistory,HttpSession session){
        log.info("进入新增&更新工作经历的接口.......");
        User user = (User)session.getAttribute("user");
        Map<String,Object> map = new HashMap<>();
        Resume resume = (Resume) session.getAttribute("resume");
        workHistory.setResumeId(resume.getResumeId());
        log.info(workHistory.toString());

        try {
            int flag;
            if(!(workHistory.getWorkHistoryId().equals(""))){
                log.info("更新工作经验");
                flag = resumeService.updateWorkHistory(workHistory);
            }else {
                log.info("新增工作经验");
                flag = resumeService.insertWorkHistory(workHistory);
            }
            if (flag == 1){
                log.info("添加工作经历成功");
                resumeService.updateUserInfo(resume);
                resume = resumeService.selectResumeById(resume.getResumeId());
                resume.setWorkHistories(resumeService.selectWorkHisByResume(resume.getResumeId()));
                map.put("state",STATE.SUCCESS);
                map.put("msg","添加工作经历成功");
            }else {
                log.info("添加工作经历失败");
                map.put("state",STATE.FAILURE);
                map.put("msg","添加工作经历失败");
            }
        }catch (Exception e){
            log.info("数据库出现异常");
            e.printStackTrace();
            map.put("state",STATE.SQL_FAILURE);
            map.put("msg","数据库繁忙，请稍后重试");
        }
        log.info(resume.getWorkHistories().toString());
        //resume.setWorkHistory(workHistory);
        session.setAttribute("resume",resume);
        map.put("resume",resume);
        return map;
    }

    /**
     * 更新个人简历
     * @param resume
     * @param session
     * @return
     */
    @ResponseBody
    @RequestMapping("/updateResume")
    public Map<String,Object> updateResume(Resume resume, HttpSession session){
        log.info("进入更新个人简历的接口.....");
        User user = (User)session.getAttribute("user");
        Map<String,Object> map = new HashMap<>();
        log.info(user.getUserName()+"：该用户的简历，更新中");
        String jobSeekerId = userService.selectJobSeekerByUserId(user.getUserId())
                .getJobSeekerId();
        resume.setJobSeekerId(jobSeekerId);

        try {
            int flag = resumeService.updateUserInfo(resume);

            if(flag == 1){
                log.info("更新简历成功");
                map.put("state", STATE.SUCCESS);
                map.put("resume",resume);
            }else {
                log.info("更新简历失败");
                map.put("state",STATE.FAILURE);
                map.put("msg","更新简历失败，请稍后重试！");
            }
        }catch (Exception e){
            log.info("数据库出现异常！");
            e.printStackTrace();
            map.put("state",STATE.SQL_FAILURE);
            map.put("msg","数据库繁忙，请稍后重试！");
        }

        return map;
    }

    /**
     * 新增，更新项目经验
     * @param projectExp
     * @param session
     * @return
     */
    @ResponseBody
    @RequestMapping("/addProjectExp")
    public Map<String,Object> insertProExp(ProjectExp projectExp,HttpSession session){
        log.info("进入新增&更新项目经验的接口.....\n"+projectExp);

        List<ProjectExp> projectExps = new ArrayList<ProjectExp>();
        Map<String,Object> map = new HashMap<>();
        Resume resume = (Resume)session.getAttribute("resume");

        try {
            int flag;
            log.info(projectExp.getProjectExpId());
            if(!(projectExp.getProjectExpId().equals(""))) {
                flag = resumeService.updateProjectExp(projectExp);
                map.put("code",3);
            }
            else {
                flag = resumeService.insertProExp(projectExp);
                map.put("code",4);
            }
            if(flag == 1){
                log.info("新增/更新项目经验成功！");
                resumeService.updateUserInfo(resume);
                resume = resumeService.selectResumeById(resume.getResumeId());
                map.put("state",STATE.SUCCESS);
                map.put("msg","新增项目经验成功");
                projectExps = resumeService.selectProExp(resume.getResumeId());
                if (projectExps != null) {
                    projectExp = projectExps.get(projectExps.size()-1);
                }
            }else {
                log.info("新增项目经验失败！");
                map.put("state",STATE.FAILURE);
                map.put("msg","新增项目经验失败");
            }

        }catch (Exception e){
            log.info("数据库出现异常！");
            log.error(e);
            e.printStackTrace();
            map.put("state",STATE.SQL_EXCEPTION);
            map.put("msg","数据库繁忙，请稍后重试！");
        }

        resume.setProjectExp(projectExp);
        resume.setProjectExps(resumeService.selectProExp(resume.getResumeId()));
        log.info(resume.getProjectExp().toString());
        session.setAttribute("resume",resume);
        map.put("resume",resume);
        return map;
    }


    @ResponseBody
    @RequestMapping("/delProExp")
    public Map<String,Object> deleteProExp(String projectExpId,HttpSession session){
        Map<String,Object> map = new HashMap<>();
        Resume resume = (Resume)session.getAttribute("resume");
        log.info("------------------------------------");
        log.info("进入删除项目经验的接口...\n"+
                "projectExpId:"+projectExpId);

        try {
            int flag;
            flag = resumeService.deleteProjectExp(projectExpId);
            if (flag == 1){
                log.info("删除项目经验成功！");
                resumeService.updateUserInfo(resume);
                resume = resumeService.selectResumeById(resume.getResumeId());
                map.put("state",STATE.SUCCESS);
                map.put("msg","删除成功");
            }else {
                log.info("删除项目经验失败！");
                map.put("state",STATE.FAILURE);
                map.put("msg","删除项目经验失败！");
            }
        }catch (Exception e){
            log.info("数据库出现异常！");
            log.info(e);
            e.printStackTrace();
            map.put("state",STATE.SQL_EXCEPTION);
            map.put("msg","数据库繁忙，请稍后重试");
        }
        resume.setProjectExps(resumeService.selectProExp(resume.getResumeId()));
        map.put("resume",resume);
        log.info(resume.getProjectExps());
        return map;
    }

    @ResponseBody
    @RequestMapping("/delWorkHis")
    public Map<String,Object> deleteWorkHis(String workHistoryId,HttpSession session){
        Map<String,Object> map = new HashMap<>();
        Resume resume = (Resume)session.getAttribute("resume");
        log.info("----------------------------------");
        log.info("进入删除工作经验的接口...\n"+
                "workHistoryId:"+workHistoryId);

        try {
            int flag;
            flag = resumeService.deleteWorkHistory(workHistoryId);
            if (flag == 1){
                log.info("删除工作经验成功！");
                resumeService.updateUserInfo(resume);
                resume = resumeService.selectResumeById(resume.getResumeId());
                map.put("state",STATE.SUCCESS);
                map.put("msg","删除成功");
            }else {
                log.info("删除工作经验失败！");
                map.put("state",STATE.FAILURE);
                map.put("msg","删除工作经验失败！");
            }
        }catch (Exception e){
            log.info("数据库出现异常！");
            log.info(e);
            e.printStackTrace();
            map.put("state",STATE.SQL_EXCEPTION);
            map.put("msg","数据库繁忙，请稍后重试");
        }
        resume.setWorkHistories(resumeService.selectWorkHisByResume(resume.getResumeId()));
        map.put("resume",resume);
        log.info(resume.getProjectExps());
        return map;
    }

    @ResponseBody
    @RequestMapping("/selectAllProExp")
    public Map<String,Object> selectProjectExp(String resumeId){
        Map<String,Object> map = new HashMap<>();
        map.put("projectExps",resumeService.selectProExp(resumeId));
        return map;
    }

    @RequestMapping("/toEmploy")
    @ResponseBody
    public Map<String,Object> toEmploy(String recruitmentId,HttpSession session){
        log.info("进入用户投递简历的接口");
        Map<String,Object> map = new HashMap<>();
        User user = (User)session.getAttribute("user");
        ToEmploy toEmploy = null;
        Resume resume = null;
        try {
            resume = resumeService.selectResumeAll(user.getUserId());
            if (resume.getEmail() == null || resume.getUniversity()==null || resume.getExceptionJob()==null ||
                    resumeService.selectProExp(resume.getResumeId()).size() == 0 ||
                    resumeService.selectWorkHisByResume(resume.getResumeId()).size() == 0){
                map.put("state",STATE.NO_DATA);
                map.put("msg","请您先完善在线简历");
            } else {
                log.info("toemploy resume:"+resume);
                toEmploy = toEmployService.selectRecordByUser(user.getUserId(),recruitmentId);
                if (toEmploy == null){
                    int flag = toEmployService.insertToEmployByUser(user.getUserId(),recruitmentId);
                    if (flag == 1){
                        log.info("投递成功");
                        map.put("state",STATE.SUCCESS);
                    }else {
                        log.info("投递失败");
                        map.put("state",STATE.FAILURE);
                        map.put("msg","投递失败，请稍后重试");
                    }
                }else {
                    log.info(toEmploy);
                    map.put("state",STATE.SQL_SUCCESS);
                    map.put("msg","您已投递过这个职位，请勿重复投递");
                }
            }
        }catch (Exception e){
            log.info("出现异常");
            e.printStackTrace();
            map.put("state",STATE.SQL_EXCEPTION);
            map.put("msg","数据库繁忙，请稍后重试");
        }

        return map;
    }

    @RequestMapping("/findHostJob")
    @ResponseBody
    public Map<String,Object> findHostJob(){
        log.info("进入查找热门职位的接口");
        Map<String,Object> map = new HashMap<>();

        List<ToEmploy> toEmploys = toEmployService.findAllRecord();
        Set<String> set = new HashSet<>();

        List<Recruitment> recruitments = new ArrayList<>();

        for(ToEmploy t:toEmploys){
            set.add(t.getRecruitmentId());
        }
        for (String id:set){
            recruitments.add(recruitmentService.selectRecruitById(id));
        }
        log.info(recruitments);

        map.put("list",recruitments);
        return map;
    }

    @RequestMapping("/viewResume")
    @ResponseBody
    public Map<String,Object> viewResume(String resumeId){

        log.info("进入预览个人简历的接口");
        Map<String,Object> map = new HashMap<>();
        Resume resume = null;
        List<ProjectExp> projectExps = null;
        List<WorkHistory> workHistories = null;

        try {
            resume = resumeService.selectResumeById(resumeId);
            resume.setProjectExps(resumeService.selectProExp(resumeId));
            resume.setWorkHistories(resumeService.selectWorkHisByResume(resumeId));

            if (resume!=null){
                log.info("查询成功");
                log.info(resume.toString());
                map.put("state",STATE.SUCCESS);
                map.put("resume",resume);
            }else {
                log.info("查询失败");
                map.put("state",STATE.FAILURE);
                map.put("msg","查询失败");
            }

        }catch (Exception e){
            log.info("数据库异常");
            e.printStackTrace();
            map.put("state",STATE.SQL_EXCEPTION);
            map.put("msg","数据库繁忙，请稍后重试");
        }
        return map;
    }

    @RequestMapping("/getToEmployResult")
    @ResponseBody
    public Map<String,Object> getResult(HttpSession session){
        log.info("进入求职者查看应聘结果的接口");
        Map<String,Object> map = new HashMap<>();
        User user = (User)session.getAttribute("user");
        List<ToEmploy> toEmploys = null;

        try {
            toEmploys = toEmployService.selectAllToEmployByUser(user.getUserId());
            if (toEmploys != null){
                log.info("查询成功");
                for (ToEmploy t:toEmploys){
                    t.setRecruitment(recruitmentService.selectRecruitById(t.getRecruitmentId()));
                }
                log.info(toEmploys);
                map.put("state",STATE.SUCCESS);
                map.put("list",toEmploys);
            }else {
                log.info("查询成功，无数据");
                map.put("state",STATE.NO_DATA);
                map.put("msg","您还没有投递过职位，请先投递职位");
            }
        } catch (Exception e) {
            log.info("出现异常");
            e.printStackTrace();
            map.put("state",STATE.FAILURE);
            map.put("msg","数据库繁忙，请稍后重试");
        }


        return map;
    }

    @RequestMapping("/findRec")
    @ResponseBody
    public Map<String,Object> findRecruitment(Recruitment recruitment){

        log.info("进入查找招聘职位的接口\n");
        Map<String,Object> map = new HashMap<>();
        DetailDeal.salaryDeal(recruitment);
        log.info(recruitment);
        List<Recruitment> recruitments = null;
        try {
            recruitments = recruitmentService.selectRecByTerm(recruitment);
            if (recruitments != null) {
                for (Recruitment r:recruitments){
                    r.setCompany(companyService.selectCompanyById(r.getCompanyId()));
                }
            }
            log.info(recruitments);
            map.put("state",STATE.SUCCESS);
            map.put("list",recruitments);
        }catch (Exception e){
            log.info("出现异常了");
            e.printStackTrace();
            map.put("state",STATE.SQL_EXCEPTION);
            map.put("msg","数据库繁忙，请稍后重试");
        }

        return map;
    }
 }
