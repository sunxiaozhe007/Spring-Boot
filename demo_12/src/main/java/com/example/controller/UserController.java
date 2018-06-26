package com.example.controller;

import com.example.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

/**
 * springBoot表单数据校验
 *
 *
 * 解决异常方式，可以在跳转页面的方法中注入一个User对象
 * 注意：由于Springmvc会将对象放入Model中传递，key的名称会使用对象的驼峰式命名规则来作为key
 * 参数的变量名需要与对象名称相同，将首字母小写
 *
 * 如果想为传递的对象更改名称，可以使用@ModelAttribute("aa")这表示当前传递的对象的key为aa
 * 那么我们在页面中获取该对象的key也需要修改为aa
 */
@Controller
public class UserController {

    @RequestMapping("/addUser")
    public String showPage(@ModelAttribute("aa") User user){
        return "add";
    }


    /**
     * 完成用户添加
     * @Valid开启对User对象的数据校验
     * BindingResult;封装了校验的结果
     */
    @RequestMapping("/save")
    public String saveUser(@ModelAttribute("aa")@Valid User user, BindingResult result){
        if (result.hasErrors()){
            return "add";
        }

        User user1 = user;
        System.out.println(user1);
        return "ok";
    }

}
