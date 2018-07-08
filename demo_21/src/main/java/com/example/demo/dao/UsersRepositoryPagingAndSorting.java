package com.example.demo.dao;

import com.example.demo.pojo.Users;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *PagingAndSortingRepository接口
 */
public interface UsersRepositoryPagingAndSorting extends PagingAndSortingRepository<Users,Integer> {


}
