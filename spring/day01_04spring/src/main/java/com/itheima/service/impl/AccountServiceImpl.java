package com.itheima.service.impl;

import com.itheima.service.AccountService;

import java.util.Date;

/**
 * 账户的业务实现类
 */
public class AccountServiceImpl implements AccountService{
    private String name;
    private Integer age;
    private Date date;
    /**
     * 模拟保存账户
     */
//    private AccountDao accountDao= new AccountDaoImpl();
//    private AccountDao accountDao= (AccountDao) BeanFactory.getBean("accountDao");
    public AccountServiceImpl(String name,  Integer age, Date date){
        this.name = name;
        this.age = age;
        this.date = date;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void saveAccount() {
        System.out.println("service中的saveAccount方法执行了......"+name+","+age+","+date);
    }
}
