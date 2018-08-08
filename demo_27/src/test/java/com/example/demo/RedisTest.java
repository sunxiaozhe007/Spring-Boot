package com.example.demo;

import com.example.demo.pojo.Users;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Spring Data Redis测试
 * @author sunxiaozhe
 * @time 2018/8/8 16:36
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    //添加一个字符串
    @Test
    public void testSet(){
        this.redisTemplate.opsForValue().set("key","孙晓哲");
    }

    //取出一个字符串
    @Test
    public void testGet(){
        String sun = String.valueOf(this.redisTemplate.opsForValue().get("key"));
        System.out.println(sun);
    }

    //添加Users对象
    @Test
    public void testSetUsers(){
        Users users = new Users();
        users.setId(10);
        users.setName("孙晓哲");
        users.setPassword("sxz");

        //重新设置序列化器
        redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());

        redisTemplate.opsForValue().set("users",users);
    }

    /**
     * 取Users对象
     */
    @Test
    public void testGetUsers(){
        //重新设置序列化器
        redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
        Users users = (Users) redisTemplate.opsForValue().get("users");
        System.out.println(users);
    }


    /**
     * 基于JSON格式存Users对象
     */
    @Test
    public void testSetUsersJSON(){
        Users users = new Users();
        users.setId(10);
        users.setName("sunxiaozhe");
        users.setPassword("sxz");

        redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<Users>(Users.class));
        redisTemplate.opsForValue().set("users_json",users);
    }

    /**
     * 基于JSON格式取Users对象
     */
    @Test
    public void testGetUsersJSON(){
        redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<Users>(Users.class));
        Users users = (Users) redisTemplate.opsForValue().get("users_json");
        System.out.println(users);
    }
}
