package com.example.service;

import com.example.dao.UserDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl {

    @Autowired
    private UserDaoImpl userDao;
    public void addUser(){

        userDao.saveUser();

    }
}
