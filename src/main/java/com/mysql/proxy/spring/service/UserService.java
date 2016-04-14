package com.mysql.proxy.spring.service;

import java.util.List;

import com.mysql.proxy.spring.bean.User;

public interface UserService {

	void save(User user);

	List<User> query();
}
