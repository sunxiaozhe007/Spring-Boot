package com.example.demo_22;

import com.example.demo_22.dao.UsersRepository;
import com.example.demo_22.pojo.Roles;
import com.example.demo_22.pojo.Users;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class  OneToManyTest {

    @Test
    public void contextLoads() {
    }


    @Autowired
    private UsersRepository usersRepository;

    /**
     * 一对多关联关系的添加
     */
    @Test
    public void testSave(){
        //创建用户
        Users users = new Users();
        users.setAddress("成仓");
        users.setAge(22);
        users.setName("孙晓");

        //创建一个角色
        Roles roles =  new Roles();
        roles.setRolename("管理员");

        //关联
        roles.getUsers().add(users);
        users.setRoles(roles);

        //保存
        usersRepository.save(users);
    }


    /**
     * 一对多关联关系的查询
     */
    @Test
    public void testFind(){
        Optional<Users> findOne = usersRepository.findById(4);
        System.out.println(findOne);

        Roles roles = findOne.get().getRoles();
        System.out.println(roles.getRolename());
    }
}
