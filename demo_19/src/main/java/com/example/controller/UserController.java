package com.example.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    @RequestMapping("/show")
    public String showPage(){
        System.out.println("sunxiaozhe......");
        System.out.println("sssssssss");
        System.out.println("springloader......");
        return "index";
    }
}
