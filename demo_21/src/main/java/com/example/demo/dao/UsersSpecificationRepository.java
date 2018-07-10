package com.example.demo.dao;

import com.example.demo.pojo.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * JpaSpecificationExecutor接口
 */
public interface UsersSpecificationRepository extends JpaRepository<Users,Integer>,JpaSpecificationExecutor<Users> {

}
