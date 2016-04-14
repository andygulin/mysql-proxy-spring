package com.mysql.proxy.spring.config;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.alibaba.druid.pool.DruidDataSource;
import com.mysql.proxy.spring.ds.CustomerContextHolder;
import com.mysql.proxy.spring.ds.DynamicDataSource;

@Configuration
@EnableTransactionManagement
@PropertySource("classpath:jdbc.properties")
public class DataSourceConfiguration {

	private static final Logger logger = Logger.getLogger(DataSourceConfiguration.class);

	@Autowired
	private Environment env;

	@Bean(name = "jdbcTemplate")
	public JdbcTemplate jdbcTemplate() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dynamicDataSource());
		logger.info("Create jdbcTemplate...");
		return jdbcTemplate;
	}

	@Bean(name = "txManager")
	public DataSourceTransactionManager txManager() {
		DataSourceTransactionManager txManager = new DataSourceTransactionManager(dynamicDataSource());
		logger.info("Create txManager...");
		return txManager;
	}

	@Bean(name = "dynamicDataSource")
	public DynamicDataSource dynamicDataSource() {
		DynamicDataSource dynamicDataSource = new DynamicDataSource();
		dynamicDataSource.setDefaultTargetDataSource(dataSourceA());

		Map<Object, Object> targetDataSources = new HashMap<>();
		targetDataSources.put(CustomerContextHolder.DATA_SOURCE_A, dataSourceA());
		targetDataSources.put(CustomerContextHolder.DATA_SOURCE_B, dataSourceB());
		dynamicDataSource.setTargetDataSources(targetDataSources);
		logger.info("Create dynamicDataSource...");
		return dynamicDataSource;
	}

	@Bean(name = CustomerContextHolder.DATA_SOURCE_A, initMethod = "init", destroyMethod = "close")
	public DataSource dataSourceA() {
		DruidDataSource dataSource = new DruidDataSource();
		dataSource.setDriverClassName(env.getProperty("jdbcA.driverClass"));
		dataSource.setUrl(env.getProperty("jdbcA.jdbcUrl"));
		dataSource.setUsername(env.getProperty("jdbcA.user"));
		dataSource.setPassword(env.getProperty("jdbcA.password"));
		dataSource.setValidationQuery("SELECT 'x'");
		logger.info("Create " + CustomerContextHolder.DATA_SOURCE_A + "...");
		return dataSource;
	}

	@Bean(name = CustomerContextHolder.DATA_SOURCE_B, initMethod = "init", destroyMethod = "close")
	public DataSource dataSourceB() {
		DruidDataSource dataSource = new DruidDataSource();
		dataSource.setDriverClassName(env.getProperty("jdbcB.driverClass"));
		dataSource.setUrl(env.getProperty("jdbcB.jdbcUrl"));
		dataSource.setUsername(env.getProperty("jdbcB.user"));
		dataSource.setPassword(env.getProperty("jdbcB.password"));
		dataSource.setValidationQuery("SELECT 'x'");
		logger.info("Create " + CustomerContextHolder.DATA_SOURCE_B + "...");
		return dataSource;
	}
}