package com.itheima.jdbc;

import com.itheima.dao.AccountDao;
import com.itheima.domain.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * JdbcTemplate的最基本用法
 */
public class JdbcTemplateDemo3 {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        AccountDao accountDao = ac.getBean("accountDao", AccountDao.class);
        Account account1 = accountDao.findById(1);
        System.out.println(account1);
        account1.setMoney(30000f);
        accountDao.updateAccount(account1);


    }


}
