package com.example.demo.dao;

import com.example.demo.pojo.Users;
import org.springframework.data.repository.CrudRepository;
/**
 * CrudRepository接口
 */
public interface UsersRepositoryCrudRepository extends CrudRepository<Users,Integer> {

}
