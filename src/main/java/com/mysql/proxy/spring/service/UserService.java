package com.mysql.proxy.spring.service;

import com.mysql.proxy.spring.bean.User;

import java.util.List;

public interface UserService {

    void save(User user);

    List<User> query();
}