package com.smsm.controller.newoptioncontroller;

import com.smsm.enumvalue.STATE;
import com.smsm.model.User;
import com.smsm.service.CompanyService;
import com.smsm.service.ResumeService;
import com.smsm.util.Upload;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/upload")
public class UploadController {

    @Autowired
    private ResumeService resumeService;

    @Autowired
    private CompanyService companyService;

    Logger log = Logger.getLogger(UploadController.class);

    @RequestMapping("/img")
    public Map<String,Object> uploadImg(HttpServletRequest request, HttpServletResponse response){

        log.info("进入上传图片的接口");
        User user = (User)request.getSession().getAttribute("user");
        Map<String,Object> map  =  new HashMap<>();
        try {
            int flag = 0;
            map = Upload.uploadImg(request,response);
            if (user.getUserType().equals("personal")){
               flag = resumeService.uploadImage(user.getUserId(),"/style/images/upload/"+(String) map.get("fileName"));
            }else {
                flag = companyService.uploadImage(user.getUserPhone(),"/style/images/upload/"+(String) map.get("fileName"));
            }
            if (flag == 1) {
                map.put("state", STATE.SUCCESS);
                log.info("上传成功"+map);
            }else {
                map.put("state",STATE.FAILURE);
                log.info("上传失败"+map);
            }
        }catch (Exception e){
            e.printStackTrace();
            map.put("state", STATE.SQL_EXCEPTION);
            map.put("msg","上传失败");
        }
        return map;
    }
}
