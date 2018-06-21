package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class HelloWord {

    @RequestMapping("/hello")
    @ResponseBody
    public Map<String,Object> showHellowWorld(){
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("msg","HelloWorld");
        return map;
    }
}
