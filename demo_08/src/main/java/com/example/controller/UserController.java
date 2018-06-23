package com.example.controller;

import com.example.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * SpringBoot整合jsp
 */
@Controller
public class UserController {

    /**
     * 处理请求，产生数据
     */
    @RequestMapping("/showUser")
    public String showUser(Model model){
        List<User> list = new ArrayList<User>();
        list.add(new User(1,"孙",24));
        list.add(new User(2,"晓",23));
        list.add(new User(3,"哲",22));
        list.add(new User(4,"oooo",21));

        //需要一个Model对象
        model.addAttribute("list",list);
        //跳转视图
        return "userList";

    }
}
