package com.smsm.controller.turnwherecontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/toLogin")
public class ToLoginController {

    @RequestMapping("/toLogin")
    public String toLogin() {
        return "login";
    }

    @RequestMapping("/toRegister")
    public String toRegister(){
        return "register";
    }

    @RequestMapping("/hello")
    public String toHello(){
        return "hello";
    }

    @RequestMapping("/index")
    public String toLoginIndex(){
        return "login_index";
    }

    @RequestMapping("/toUpdatePwd")
    public String toUpdatePwd(){
        return "updatePwd";
    }
}
