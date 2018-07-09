package com.example.demo.dao;

import com.example.demo.pojo.Users;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.List;

/**
 * Repository  @Query
 */
public interface UsersRepositoryQueryAnnotation extends Repository<Users,Integer> {

    @Query("from Users where name = ?1")
    List<Users> queryByNameUseHQL(String name);

    @Query(value = "select * from t_users where name = ?",nativeQuery = true)
    List<Users> queryByNameUseSQL(String name);

    @Query(value = "update t_users set name = ? where id = ?",nativeQuery = true)
    @Modifying//需要执行一个更新操作
    void updateUsersNameById(String name,Integer id);
}
