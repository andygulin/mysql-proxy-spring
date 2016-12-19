package com.mysql.proxy.spring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = {"com.mysql.proxy.spring.dao", "com.mysql.proxy.spring.service"})
@Import(DataSourceConfiguration.class)
public class AppConfig {

}
