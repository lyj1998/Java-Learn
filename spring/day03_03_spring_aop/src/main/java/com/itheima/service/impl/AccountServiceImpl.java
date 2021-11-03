package com.itheima.service.impl;

import com.itheima.service.AccountService;

public class AccountServiceImpl implements AccountService {
    /**
     * 模拟保存账户
     */
    public void saveAccount() {
        System.out.println("执行了保存");
    }

    /**
     * 模拟更新账户
     * @param i
     */
    public void updateAccount(int i) {
        System.out.println("执行了更新");
    }

    /**
     * 删除账户
     * @return
     */
    public int deleteAccount() {
        System.out.println("执行了删除");
        return 0;
    }
}
