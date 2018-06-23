package com.example.controller;


import com.example.pojo.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 页面跳转
     */
    @RequestMapping("/{page}")
    public String showPage(@PathVariable String page){
        return page;
    }
    /**
     * 添加用户
     */
    @RequestMapping("/addUser")
    public String addUser(User user){
        userService.addUser(user);
        return "ok";
    }
    /**
     * 查询所有用户
     */
    @RequestMapping("/findUserAll")
    public String findUserAll(Model model){
        List<User> list = userService.findUserAll();
        model.addAttribute("list",list);
        return "showUser";
    }
    /**
     * 根据用户id查询用户
     */
    @RequestMapping("/findById")
    public String findUserById(Integer id,Model model){
        User user = userService.findUserById(id);
        model.addAttribute("user",user);
        return "updateUser";
    }
    /**
     * 修改用户
     */
    @RequestMapping("/editUser")
    public String editUser(User user){
        userService.updateUser(user);
        return "ok";
    }
    /**
     * 用户删除
     */
    @RequestMapping("/deleteUser")
    public String deleteUser(Integer id){
        userService.deleteUserById(id);
        return "redirect:/user/findUserAll";
    }
}
