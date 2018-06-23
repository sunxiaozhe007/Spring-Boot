package com.example.service;

import com.example.pojo.User;
import java.util.List;

public interface UserService {

    void addUser(User user);

    List<User> findUserAll();

    User findUserById(Integer id);

    void updateUser(User user);

    void deleteUserById(Integer id);
}
