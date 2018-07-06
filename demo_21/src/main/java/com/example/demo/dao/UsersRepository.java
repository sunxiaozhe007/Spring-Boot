package com.example.demo.dao;

import com.example.demo.pojo.Users;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 参数一：当前需要映射的实体
 * 参数二：当前映射的实体中的OID的类型
 */
public interface UsersRepository extends JpaRepository<Users,Integer> {

}
