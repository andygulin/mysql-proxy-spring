package com.mysql.proxy.spring.dao;

import java.util.List;

import com.mysql.proxy.spring.bean.User;

public interface UserDao {

	void save(User user);

	List<User> query();
}
