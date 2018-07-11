package com.example.demo_22;

import com.example.demo_22.dao.RolesRepository;
import com.example.demo_22.pojo.Menus;
import com.example.demo_22.pojo.Roles;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Set;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ManyToManyTest {

    @Test
    public void contextLoads() {
    }

    @Autowired
    private RolesRepository rolesRepository;

    /**
     * 添加测试
     */
    @Test
    public void testSave(){
        //创建角色对象
        Roles roles = new Roles();
        roles.setRolename("经理");

        //创建菜单对象
        Menus menus = new Menus();
        menus.setMenusname("XXXX管理系统");
        menus.setFatherid(0);

        Menus menus1 = new Menus();
        menus1.setFatherid(1);
        menus1.setMenusname("项目管理");

        //关联
        roles.getMenus().add(menus);
        roles.getMenus().add(menus1);
        menus.getRoles().add(roles);
        menus1.getRoles().add(roles);

        //保存
        rolesRepository.save(roles);
    }


    /**
     * 查询操作
     */
    @Test
    public void testFind(){
        Roles roles = rolesRepository.findOne(2);

        System.out.println(roles.getRolename());

        Set<Menus> menus = roles.getMenus();

        for (Menus menus1 : menus){
            System.out.println(menus1);
        }
    }
}
