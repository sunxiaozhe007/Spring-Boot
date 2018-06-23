package com.example.mapper;

import com.example.pojo.User;

import java.util.List;

public interface UserMapper {

    void insertUser(User user);

    List<User> selectUserAll();

    User selectUserById(Integer id);

    void updateUser(User user);

    void deleteUserById(Integer id);
}
