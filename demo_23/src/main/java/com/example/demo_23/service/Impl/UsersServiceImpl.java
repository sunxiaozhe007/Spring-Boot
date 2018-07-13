package com.example.demo_23.service.Impl;

import com.example.demo_23.dao.UsersRepository;
import com.example.demo_23.pojo.Users;
import com.example.demo_23.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * UsersService接口实现类
 */
@Service
public class UsersServiceImpl implements UserService {

    @Autowired
    private UsersRepository usersRepository;


    @Override
    @Cacheable(value = "Users")
    public List<Users> findUserAll() {
        return usersRepository.findAll();
    }

    @Override
    //@Cacheable:对当前查询的对象做缓存处理
    @Cacheable(value = "Users")
    public Optional<Users> findUserById(Integer id) {
        return usersRepository.findById(id);
    }

    @Override
    @Cacheable(value = "Users",key = "#pageable.pageSize")
    public Page<Users> findUserByPage(Pageable pageable) {
        return usersRepository.findAll(pageable);
    }

    @Override
    @CacheEvict(value = "Users",allEntries = true)
    public void saveUsers(Users users) {
        usersRepository.save(users);
    }
}
