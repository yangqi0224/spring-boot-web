package com.smsm.controller.testcontroller;

import com.smsm.model.User;
import com.smsm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Controller
public class TestController {

    @Autowired
    UserService userService;

    @RequestMapping("/test")
    public Map<String,Object> findUser(Model model) {
        User user;

        Map<String,Object> map = new HashMap<String, Object>();
        System.out.println("lailelaodi");
        user = userService.findUserInfo("13280845908");
        map.put("user",user);
        map.put("msg","success");
        return map;
    }

    @RequestMapping("/toudi")
    public String toToudi(@RequestParam("createTime")String createTime){
        System.out.println(createTime);
        return "toudi";
    }
}
