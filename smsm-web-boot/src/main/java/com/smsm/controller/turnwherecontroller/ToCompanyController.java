package com.smsm.controller.turnwherecontroller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/toCompany")
public class ToCompanyController {

    @RequestMapping("/toIndex")
    public String toIndex() {
        return "index";
    }

    @RequestMapping("/toMyCompany")
    public String toMyCompany(){
        return "myhome";
    }

    @RequestMapping("/viewRes")
    public String viewRes(){
        return "canInterviewResumes";
    }
    @RequestMapping("/createRec")
    public String toRec(HttpSession session){
        return "create";
    }
    @RequestMapping("/toCompany01")
    public String toIndex01() {
        return "index01";
    }

    @RequestMapping("/toCompany02")
    public String toIndex02() {
        return "index02";
    }

    @RequestMapping("/toCompany03")
    public String toIndex03() {
        return "index03";
    }

    @RequestMapping("/toCompany04")
    public String toIndex04() {
        return "index04";
    }
}
