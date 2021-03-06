package com.itheima.jdbc;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * JdbcTemplate的最基本用法
 */
public class JdbcTemplateDemo {
    public static void main(String[] args) {
        //准备数据源，spring的内置数据源
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/eesy");
        ds.setUsername("root");
        ds.setPassword("root");
        //1.创建JdbcTemplate对象
        JdbcTemplate jt = new JdbcTemplate();
        //2.给jt设置数据源
       jt.setDataSource(ds);
        //2.执行操作
        jt.execute("insert into account(name,money)values('ccc',1000)");
    }


}
