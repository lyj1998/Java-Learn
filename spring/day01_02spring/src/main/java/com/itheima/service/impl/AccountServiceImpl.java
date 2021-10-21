package com.itheima.service.impl;

import com.itheima.dao.AccountDao;
import com.itheima.dao.impl.AccountDaoImpl;
import com.itheima.factory.BeanFactory;
import com.itheima.service.AccountService;

/**
 * 账户的业务实现类
 */
public class AccountServiceImpl implements AccountService{
    /**
     * 模拟保存账户
     */
//    private AccountDao accountDao= new AccountDaoImpl();
    private AccountDao accountDao= (AccountDao) BeanFactory.getBean("accountDao");

    @Override
    public void saveAccount() {
        accountDao.saveAccount();
    }
}
