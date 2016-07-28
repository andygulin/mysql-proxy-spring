package com.mysql.proxy.spring.bean;

import java.io.Serializable;
import java.util.Date;

import com.alibaba.fastjson.JSON;

public class User implements Serializable {

	private static final long serialVersionUID = 4913969154309588768L;

	private Integer id;
	private String name;
	private Integer age;
	private String address;
	private Date createdAt;

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

	public Integer getAge() {
		return age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}
}