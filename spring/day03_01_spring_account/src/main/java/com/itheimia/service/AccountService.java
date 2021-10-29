package com.itheimia.service;

import com.itheimia.dao.AccountDao;
import com.itheimia.domain.Account;

import java.util.List;


public interface AccountService {
    /**
     * 查询所有
     * @return
     */
    List<Account> findAllAccount();
    /**
     * 查询一个
     */
    Account findAccountById(Integer accountId);
    /**
     * 保存操作
     */
    void saveAccount(Account account);

    /**
     * 更新
      * @param account
     */
    void updateAccount(Account account);

    /**
     * 删除
     * @param accountId
     */
    void deleteAccount(Integer accountId);

    /**
     * 转账
     */
    void transfer(String sourceName, String targetName, Float money);
}
