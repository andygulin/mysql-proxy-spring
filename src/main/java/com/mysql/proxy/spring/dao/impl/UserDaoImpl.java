package com.mysql.proxy.spring.dao.impl;

import com.mysql.proxy.spring.bean.User;
import com.mysql.proxy.spring.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void save(final User user) {
        String sql = "INSERT INTO `user`(`name`,age,address,createdAt) VALUES(?,?,?,?)";
        jdbcTemplate.update(sql, ps -> {
            ps.setString(1, user.getName());
            ps.setInt(2, user.getAge());
            ps.setString(3, user.getAddress());
            ps.setObject(4, user.getCreatedAt());
        });
    }

    @Override
    public List<User> query() {
        String sql = "SELECT * FROM `user`";
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(User.class));
    }

}