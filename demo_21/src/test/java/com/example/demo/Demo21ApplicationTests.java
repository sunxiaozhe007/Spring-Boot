package com.example.demo;

import com.example.demo.dao.*;
import com.example.demo.pojo.Users;
import org.apache.catalina.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Demo21ApplicationTests {

    @Test
    public void contextLoads() {
    }


    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private UsersRepositoryByName usersRepositoryByName;

    @Autowired
    private UsersRepositoryQueryAnnotation usersRepositoryQueryAnnotation;

    @Autowired
    private UsersRepositoryCrudRepository usersRepositoryCrudRepository;

    @Autowired
    private UsersRepositoryPagingAndSorting usersRepositoryPagingAndSorting;

    @Autowired
    private UsersSpecificationRepository usersSpecificationRepository;

    @Test
    public void testSave(){
        Users users = new Users();
        users.setAddress("宝鸡");
        users.setAge(21);
        users.setName("孙晓哲");
        usersRepository.save(users);
    }


    /**
     * Repository--方法名称命名测试
     */
    @Test
    public void testFindByName(){
        List<Users> list = usersRepositoryByName.findByName("孙晓哲");
        for (Users users : list){
            System.out.println(users);
        }
    }

    @Test
    public void testFindByNameAndAge(){
        List<Users> list = usersRepositoryByName.findByNameAndAge("孙晓哲",21);
        for (Users users : list){
            System.out.println(users);
        }
    }


    @Test
    public void testFindByNameLike(){
        List<Users> list = usersRepositoryByName.findByNameLike("%张%");
        for (Users users : list){
            System.out.println(users);
        }
    }


    /**
     * Repository--@Query测试
     */

    @Test
    public void testQueryByNameUseHQL(){
        List<Users> list = usersRepositoryQueryAnnotation.queryByNameUseHQL("孙晓哲");
        for (Users users : list){
            System.out.println(users);
        }
    }

    @Test
    public void testQueryByNameUseSQL(){
        List<Users> list = usersRepositoryQueryAnnotation.queryByNameUseSQL("孙晓哲");
        for (Users users : list){
            System.out.println(users);
        }
    }


    @Test
    @Transactional//@Transactional与@Test一起使用时事物是自动回滚的。
    @Rollback(false)//取消自动回滚
    public void testUpdateUsersNameById() {
        usersRepositoryQueryAnnotation.updateUsersNameById("sunxiaozhe", 1);
    }

    /**
     * CrudRepository测试
     */
    @Test
    public void testCrudRepositorySave(){
        Users users = new Users();
        users.setName("李四");
        users.setAge(22);
        users.setAddress("宝鸡");
        usersRepositoryCrudRepository.save(users);
    }


    @Test
    public void testCrudRepositoryUpdate(){
        Users users = new Users();
        users.setId(5);
        users.setName("李四");
        users.setAge(22);
        users.setAddress("宝鸡");
        usersRepositoryCrudRepository.save(users);
    }

    @Test
    public void testCrudRepositoryFindOne(){
        Optional<Users> users = usersRepositoryCrudRepository.findById(5);
        System.out.println(users);
    }

    @Test
    public void testCrudRepositoryFindAll(){
        List<Users> list = (List<Users>) usersRepositoryCrudRepository.findAll();
        for (Users users : list){
            System.out.println(users);
        }
    }

    @Test
    public void testCrudRepositoryDeleteById(){
        usersRepositoryCrudRepository.deleteById(8);
    }

    /**
     *PageAndSortingRepository测试--排序测试
     */
    @Test
    public void testPagingAndSortingRepositorySort(){
        //Order定义排序规则
        Sort.Order order = new Sort.Order(Sort.Direction.DESC,"id");

        //sort对象封装了排序规则
        Sort sort = new Sort(order);
        List<Users> list = (List<Users>) usersRepositoryPagingAndSorting.findAll(sort);
        for (Users users : list){
            System.out.println(users);
        }
    }

    /**
     *PageAndSortingRepository测试--分页测试
     */
    @Test
    public void testPagingAndSortingRepositoryPaging(){
        //Pageable:封装了分页的参数，当前页，每页显示的条数，注意，他的当前页是从0开始的
        //PageRequest(page,size):page:当前页，size：每页的条数
        Pageable pageable = new PageRequest(2,2);
        Page<Users> page = usersRepositoryPagingAndSorting.findAll(pageable);
        System.out.println("总条数："+page.getTotalElements());
        System.out.println("总页数："+page.getTotalPages());
        List<Users> list = page.getContent();
        for (Users users : list){
            System.out.println(users);
        }
    }


    /**
     *PageAndSortingRepository测试--排序+分页
     */
    @Test
    public void testPagingAndSortingRepositorySortAndPaging(){
       Sort sort = new Sort(new Sort.Order(Sort.Direction.DESC,"id"));

       Pageable pageable = new PageRequest(0,2,sort);

       Page<Users> page = usersRepositoryPagingAndSorting.findAll(pageable);

        System.out.println("总条数："+page.getTotalElements());
        System.out.println("总页数："+page.getTotalPages());
        List<Users> list = page.getContent();
        for (Users users : list){
            System.out.println(users);
        }
    }



    /**
     * JpaRepository测试--排序测试
     */
    @Test
    public void testJpaRepositorySort(){
        //Order定义排序规则
        Sort.Order order = new Sort.Order(Sort.Direction.DESC,"id");

        //sort对象封装了排序规则
        Sort sort = new Sort(order);
        List<Users> list = usersRepository.findAll(sort);
        for (Users users : list){
            System.out.println(users);
        }
    }


    /**
     * JpaSpecificationExecutor接口测试--单条件查询测试
     */
    @Test
    public void testJpaSpecificationExecutor1(){

        /**
         * Specification<Users>:用于封装查询条件
         *
         * 参数一：Root<Users> root：查询对象的属性的封装
         * 参数二：CriteriaQuery<?> criteriaQuery：封装了我们执行的查询中的各个部分的信息，select from order
         * 参数三：CriteriaBuilder criteriaBuilder：查询条件的构造器，定义不同的查询条件
         */
        Specification<Users> specification = new Specification<Users>() {
            @Override
            public Predicate toPredicate(Root<Users> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                //where name = “孙晓哲”
                /**
                 * equal参数
                 * 参数一：查询的条件属性
                 * 参数二：条件的值
                 */
                Predicate predicate = criteriaBuilder.equal(root.get("name"),"孙晓哲");
                return predicate;
            }
        };
        List<Users> list = usersSpecificationRepository.findAll(specification);

                for(Users users : list){
                    System.out.println(users);
                }
    }


    /**
     * JpaSpecificationExecutor接口测试--多条件查询测试1
     */
    @Test
    public void testJpaSpecificationExecutor2(){

        /**
         * Specification<Users>:用于封装查询条件
         *
         * 参数一：Root<Users> root：查询对象的属性的封装
         * 参数二：CriteriaQuery<?> criteriaQuery：封装了我们执行的查询中的各个部分的信息，select from order
         * 参数三：CriteriaBuilder criteriaBuilder：查询条件的构造器，定义不同的查询条件
         */
        Specification<Users> specification = new Specification<Users>() {
            @Override
            public Predicate toPredicate(Root<Users> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                //where name = “孙晓哲” and age = 21
                List<Predicate> list = new ArrayList<>();
                list.add(criteriaBuilder.equal(root.get("name"),"孙晓哲"));
                list.add(criteriaBuilder.equal(root.get("age"),"21"));
                Predicate[] arr = new Predicate[list.size()];
                return criteriaBuilder.and(list.toArray(arr));
            }
        };
        List<Users> list = usersSpecificationRepository.findAll(specification);

        for(Users users : list){
            System.out.println(users);
        }
    }



    /**
     * JpaSpecificationExecutor接口测试--多条件查询测试2
     */
    @Test
    public void testJpaSpecificationExecutor3(){

        /**
         * Specification<Users>:用于封装查询条件
         *
         * 参数一：Root<Users> root：查询对象的属性的封装
         * 参数二：CriteriaQuery<?> criteriaQuery：封装了我们执行的查询中的各个部分的信息，select from order
         * 参数三：CriteriaBuilder criteriaBuilder：查询条件的构造器，定义不同的查询条件
         */
        Specification<Users> specification = new Specification<Users>() {
            @Override
            public Predicate toPredicate(Root<Users> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {

                return criteriaBuilder.or(criteriaBuilder.equal(root.get("name"),"孙晓哲"),criteriaBuilder.equal(root.get("age"),22));
            }
        };
        Sort sort = new Sort(new Sort.Order(Sort.Direction.DESC,"id"));
        List<Users> list = usersSpecificationRepository.findAll(specification,sort);

        for(Users users : list){
            System.out.println(users);
        }
    }
}
