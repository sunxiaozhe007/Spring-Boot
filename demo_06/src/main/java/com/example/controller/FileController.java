package com.example.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController//该类下所有方法都会自动转换json格式
public class FileController {
    /**
     * 处理文件上传
     */
    @RequestMapping("/fileUploadController")
    public Map<String ,Object> fileUpload(MultipartFile filename) throws IOException {
        System.out.println(filename.getOriginalFilename());
        filename.transferTo(new File("D:/"+filename.getOriginalFilename()));
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("msg","ok");
        return map;
    }
}
