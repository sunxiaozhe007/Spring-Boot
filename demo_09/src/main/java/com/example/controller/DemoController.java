package com.example.controller;

import com.example.domain.User;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;

/**
 * Thymeleaf入门案例
 */
@Controller
public class DemoController {

    @RequestMapping("/show")
    public String showInfo(Model model){
        model.addAttribute("msg","Thymeleaf第一个案例");
        model.addAttribute("key",new Date());
        return "index";
    }


    @RequestMapping("/show2")
    public String showInfo2(Model model){
        model.addAttribute("sex","女");
        model.addAttribute("id","2");
        return "index2";
    }

    @RequestMapping("/show3")
    public String showInfo3(Model model){
        List<User> list = new ArrayList<User>();
        list.add(new User(1,"孙",20));
        list.add(new User(2,"晓",21));
        list.add(new User(3,"哲",22));
        model.addAttribute("list",list);
        return "index3";
    }

    @RequestMapping("show4")
    public String showInfo4(Model model){
        Map<String,User> map = new HashMap<String, User>();
        map.put("m1",new User(1,"sun",20));
        map.put("m2",new User(2,"xiao",21));
        map.put("m3",new User(3,"zhe",22));
        model.addAttribute("map",map);
        return "index4";
    }

    @RequestMapping("show5")
    public String showInfo5(HttpServletRequest request,Model model){
        request.setAttribute("req","HttpServletRequest");
        request.getSession().setAttribute("session","HttpSession");
        request.getSession().getServletContext().setAttribute("app","Application");
        return "index5";
    }
}
