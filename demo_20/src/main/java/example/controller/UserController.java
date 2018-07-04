package example.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    @RequestMapping("/show")
    public String showPage(){
        System.out.println("sunnxiaozhe....aaaa");
        System.out.println("aaaaaaaaa");
        System.out.println("dddddddddddd");
        return "index";
    }
}
