package com.mysql.proxy.spring;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.mysql.proxy.spring.bean.User;
import com.mysql.proxy.spring.config.AppConfig;
import com.mysql.proxy.spring.ds.CustomerContextHolder;
import com.mysql.proxy.spring.service.UserService;

@ContextConfiguration(classes = AppConfig.class)
public class ProxyTest extends AbstractJUnit4SpringContextTests {

	@Autowired
	private UserService userService;

	@Test
	public void save() {
		CustomerContextHolder.setCustomerType(CustomerContextHolder.DATA_SOURCE_A);
		User user = new User();
		user.setName("小明");
		user.setAge(12);
		user.setAddress("上海");
		user.setCreatedAt(new Date());
		userService.save(user);
		System.out.println("Save User : " + user);

		CustomerContextHolder.setCustomerType(CustomerContextHolder.DATA_SOURCE_B);
		User user2 = new User();
		user2.setName("小明");
		user2.setAge(12);
		user2.setAddress("上海");
		user2.setCreatedAt(new Date());
		userService.save(user2);
		System.out.println("Save User : " + user);
	}

	@Test
	public void query() {
		CustomerContextHolder.setCustomerType(CustomerContextHolder.DATA_SOURCE_A);
		List<User> users = userService.query();
		System.out.println(users);

		CustomerContextHolder.setCustomerType(CustomerContextHolder.DATA_SOURCE_B);
		users = userService.query();
		System.out.println(users);
	}
}