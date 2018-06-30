package example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    @RequestMapping("showUser")
    public String showUser(){
        String str = null;
        str.length();
        return "index";
    }

    @RequestMapping("showUser2")
    public String showUser2(){
        int a = 10/0;
        return "index";
    }
}
