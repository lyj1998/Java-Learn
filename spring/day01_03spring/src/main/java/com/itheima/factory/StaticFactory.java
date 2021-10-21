package com.itheima.factory;

import com.itheima.service.AccountService;
import com.itheima.service.impl.AccountServiceImpl;

public class StaticFactory {
    public static AccountService getAccountService(){
        return new AccountServiceImpl();
    }
}
