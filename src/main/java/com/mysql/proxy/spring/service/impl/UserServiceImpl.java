package com.mysql.proxy.spring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mysql.proxy.spring.bean.User;
import com.mysql.proxy.spring.dao.UserDao;
import com.mysql.proxy.spring.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Transactional(rollbackFor = Exception.class)
	@Override
	public void save(final User user) {
		userDao.save(user);
	}

	@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	@Override
	public List<User> query() {
		return userDao.query();
	}
}