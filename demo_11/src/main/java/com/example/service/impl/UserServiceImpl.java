package com.example.service.impl;

import com.example.mapper.UserMapper;
import com.example.pojo.User;
import com.example.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public void addUser(User user) {
        userMapper.insertUser(user);
    }

    @Override
    public List<User> findUserAll() {
        return userMapper.selectUserAll();
    }

    @Override
    public User findUserById(Integer id) {
        return userMapper.selectUserById(id);
    }

    @Override
    public void updateUser(User user) {
        userMapper.updateUser(user);
    }

    @Override
    public void deleteUserById(Integer id) {
        userMapper.deleteUserById(id);
    }
}
