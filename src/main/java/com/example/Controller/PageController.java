package com.example.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

@CrossOrigin
@Controller
public class PageController {

    /**【登录页】**/
    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    /**【首页】**/
    @RequestMapping("/Index")
    public String Index(){
        return "Index";
    }

    /**【收费登记】**/
    @RequestMapping("/freeRegistration")
    public String freeRegistration(){
        return "freeRegistration";
    }

    /**【收费记录】**/
    @RequestMapping("/recordTab")
    public String recordTab(){
        return "recordTab";
    }

    /**【修改个人信息】**/
    @RequestMapping("/editPersonInfo")
    public String editPersonalInfo(){
        return "personalInfo";
    }

    /**【用户管理】**/
    @RequestMapping("/userManager")
    public String userManager(){
        return "userManager";
    }
}
