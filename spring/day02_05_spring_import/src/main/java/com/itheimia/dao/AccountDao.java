package com.itheimia.dao;

import com.itheimia.domain.Account;

import java.util.List;

public interface AccountDao {
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
}
