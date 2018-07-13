package com.example.demo_23.service;

import com.example.demo_23.pojo.Users;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<Users> findUserAll();
    Optional<Users> findUserById(Integer id);
    Page<Users> findUserByPage(Pageable pageable);
    void saveUsers(Users users);
}
