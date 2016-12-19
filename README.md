# spring多数据源处理

### 初始化数据
```sql
CREATE SCHEMA `test` DEFAULT CHARACTER SET utf8;
	
CREATE TABLE `test`.`user` (
`id` int(11) NOT NULL AUTO_INCREMENT,
`name` varchar(20) DEFAULT NULL,
`age` int(11) DEFAULT NULL,
`address` varchar(100) DEFAULT NULL,
`createdAt` datetime DEFAULT NULL,
PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE SCHEMA `test2` DEFAULT CHARACTER SET utf8;

CREATE TABLE `test2`.`user` (
`id` int(11) NOT NULL AUTO_INCREMENT,
`name` varchar(20) DEFAULT NULL,
`age` int(11) DEFAULT NULL,
`address` varchar(100) DEFAULT NULL,
`createdAt` datetime DEFAULT NULL,
PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
```
	
	
### 测试
```
com.mysql.proxy.spring.ProxyTest#save
com.mysql.proxy.spring.ProxyTest#query
```