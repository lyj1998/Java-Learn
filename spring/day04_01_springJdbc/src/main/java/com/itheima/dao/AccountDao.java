package com.itheima.dao;

import com.itheima.domain.Account;

/**
 * 用户的持久层接口
 */
public interface AccountDao {
    /**
     * 根据id查询账户
     *
     * @param id
     * @return
     */
    public Account findById(Integer id);

    /**
     * 根据名称查询账户
     *
     * @param accountName
     * @return
     */
    public Account findByName(String accountName);

    /**
     * 更新账户
     * @param account
     */
    void updateAccount(Account account);

}
