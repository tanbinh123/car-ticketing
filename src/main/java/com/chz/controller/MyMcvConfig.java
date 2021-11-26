package com.chz.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author snicker
 * @date 2021/11/10 17:38
 * @Describe
 */
@Controller
public class MyMcvConfig {

    @RequestMapping("/")
    public String showfirst(){
        return "redirect:/fontpage/login.html";

    }

    @RequestMapping("/admin")
    public String showadmin(){
        return "redirect:/admin/login.html";
    }

}
