package com.example.demo_23;

import com.example.demo_23.pojo.Users;
import com.example.demo_23.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Demo23ApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Autowired
    private UserService userService;

    @Test
    public void testFindUserById(){
        //第一次查询
        System.out.println(userService.findUserById(10));


        //第二次查询
        System.out.println(userService.findUserById(10));
    }

    @Test
    public void testFindUserByPage(){
        Pageable pageable = new PageRequest(0,2);
        //第一次查询
        System.out.println(userService.findUserByPage(pageable).getTotalElements());

        //第二次查询
        System.out.println(userService.findUserByPage(pageable).getTotalElements());

        //第三次查询
        Pageable pageable1 = new PageRequest(1,2);
        System.out.println(userService.findUserByPage(pageable1).getTotalElements());
    }

    @Test
    public void testFindAll(){

        //第一次查询
        System.out.println(userService.findUserAll().size());

        Users users = new Users();
        users.setAddress("西安");
        users.setAge(25);
        users.setName("张五");
        userService.saveUsers(users);

        //第二次查询
        System.out.println(userService.findUserAll().size());


    }

}
