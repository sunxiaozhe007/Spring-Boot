package com.example.test;

import com.example.App;
import com.example.service.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * springBoot启动类
 * @RunWith：启动器
 * SpringJUnit4ClassRunner.class:让Junit与Spring环境进行整合
 * @SpringBootTest(classes = {App.class}):1.当前类为springBoot的测试类
 * @SpringBootTest(classes = {App.class})：2.加载SpringBoot启动类，启动SpringBoot
 *
 * junit与spring整合@Contextconfiguartion（“classpath：applicationContext.xml”）
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {App.class})
public class UserServiceTest {

    @Autowired
    private UserServiceImpl userService;

    @Test
    public void testAddUser(){
        userService.addUser();
    }
}
