package com.itheima.service.impl;

import com.itheima.dao.AccountDao;
import com.itheima.dao.impl.AccountDaoImpl;
import com.itheima.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 账户的业务实现类
 */
public class AccountServiceImpl implements AccountService{
    /**
     * 模拟保存账户
     */
//    private AccountDao accountDao= new AccountDaoImpl();
//    private AccountDao accountDao= (AccountDao) BeanFactory.getBean("accountDao");
    public AccountServiceImpl(){
        System.out.println("对象创建了..");
    }
    public void saveAccount() {
        System.out.println("service中的saveAccount方法执行了.....");
    }
    public void init(){
        System.out.println("对象初始化了");
    }
    public void destroy(){
        System.out.println("对象销毁了");
    }
}
