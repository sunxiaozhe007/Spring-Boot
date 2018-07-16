package com.example.demo_26;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;


/**
 * spring Boot 整合Quartz案例
         */
@SpringBootApplication
@EnableScheduling
public class Demo26Application {

    public static void main(String[] args) {
        SpringApplication.run(Demo26Application.class, args);
    }
}
