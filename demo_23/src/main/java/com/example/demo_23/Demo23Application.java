package com.example.demo_23;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class Demo23Application {

    public static void main(String[] args) {
        SpringApplication.run(Demo23Application.class, args);
    }
}
