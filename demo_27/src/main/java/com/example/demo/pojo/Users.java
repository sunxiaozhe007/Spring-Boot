package com.example.demo.pojo;

import java.io.Serializable;

/**
 * @author sunxiaozhe
 * @time 2018/8/8 19:07
 */
public class Users implements Serializable {

    private Integer id;

    private String name;

    private String password;

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
