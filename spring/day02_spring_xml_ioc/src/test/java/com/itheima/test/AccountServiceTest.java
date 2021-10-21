package com.itheima.test;

import com.itheimia.domain.Account;
import com.itheimia.service.AccountService;
import com.itheimia.service.impl.AccountServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * 使用Junit单元测试，测试我们的配置
 */
public class AccountServiceTest {
    @Test
    public void testFindAll(){
        //1.获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.得到业务层方法
        AccountService as = ac.getBean("accountService", AccountService.class);
        //3.执行方法
        List<Account> accounts = as.findAllAccount();
        for(Account account: accounts){
            System.out.println(account);
        }
    }

    @Test
    public void testFindOne(){
        //1.获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.得到业务层方法
        AccountService as = ac.getBean("accountService", AccountService.class);
        //3.执行方法
        Account account = as.findAccountById(1);
        System.out.println(account);
    }

    @Test
    public void testSave(){
        Account account = new Account();
        account.setName("小卢");
        account.setMoney(45f);
        //1.获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.得到业务层方法
        AccountService as = ac.getBean("accountService", AccountService.class);
        //3.执行方法
        as.saveAccount(account);
    }


    @Test
    public void testUpdate(){
        //1.获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.得到业务层方法
        AccountService as = ac.getBean("accountService", AccountService.class);
        Account account = as.findAccountById(2);
        account.setName("求求百度的offer");
        //3.执行方法
        as.updateAccount(account);
    }

    @Test
    public void testDelete(){
        //1.获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.得到业务层方法
        AccountService as = ac.getBean("accountService", AccountService.class);
        //3.执行方法
        as.deleteAccount(3);
    }
}
