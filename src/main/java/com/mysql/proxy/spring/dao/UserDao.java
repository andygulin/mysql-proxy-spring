package com.mysql.proxy.spring.dao;

import com.mysql.proxy.spring.bean.User;

import java.util.List;

public interface UserDao {

    void save(User user);

    List<User> query();
}
