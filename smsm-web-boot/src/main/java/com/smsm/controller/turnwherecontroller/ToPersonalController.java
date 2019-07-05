package com.smsm.controller.turnwherecontroller;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/toPersonal")
@Controller
public class ToPersonalController {

    @RequestMapping("/toResult")
    public String toResult(){
        return "delivery";
    }

    @RequestMapping("/toList")
    public String toList(){
        return "list";
    }

}
