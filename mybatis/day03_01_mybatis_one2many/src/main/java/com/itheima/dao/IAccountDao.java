package com.itheima.dao;

import com.itheima.domain.Account;
import com.itheima.domain.AccountUser;

import java.util.List;

public interface IAccountDao {
    List<Account> findAll();
    Account findById(Integer id);

    /**
     * 查询所有账户同时包含用户名和地址信息
     * @return
     */
    List<AccountUser> findAllAccount();
}
