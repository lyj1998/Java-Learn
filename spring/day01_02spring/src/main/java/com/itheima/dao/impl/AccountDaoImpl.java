package com.itheima.dao.impl;

import com.itheima.dao.AccountDao;

/**
 * 账户的持久层实现类
 */
public class AccountDaoImpl implements AccountDao {
    private int i = 1;
    @Override
    public void saveAccount() {
        System.out.println("保存了账户");
        System.out.println(i);
        i++;
    }
}
