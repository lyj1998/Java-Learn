package com.itheima.test;

import com.itheimia.domain.Account;
import com.itheimia.service.AccountService;
import com.itheimia.service.impl.AccountServiceImpl;
import config.SpringConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * 使用Junit单元测试，测试我们的配置
 * Spring整合Junit的配置
 *   1.导入spring整合Junit的jar(坐标)
 *   2.使用Junit提供的一个注释把原有的main方法替换了，替换成spring提供的
 *   @Runwith
 *   3.告知spring的运行器，spring和ioc创建爱你是基于xml还是注解的，并且说明位置
 *   @COntextConfiguration
 *                locations:指定xml文件的位置，加上classpath关键字，表示在类路径下
 *                classes：指定注解类所在的位置
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class AccountServiceTest {
    @Autowired
    private AccountService as;
    @Test
    public void testFindAll(){
        //3.执行方法
        List<Account> accounts = as.findAllAccount();
        for(Account account: accounts){
            System.out.println(account);
        }
    }

    @Test
    public void testFindOne(){
        //3.执行方法
        Account account = as.findAccountById(1);
        System.out.println(account);
    }

    @Test
    public void testSave(){
        Account account = new Account();
        account.setName("小卢");
        account.setMoney(45f);
        //3.执行方法
        as.saveAccount(account);
    }


    @Test
    public void testUpdate(){
        Account account = as.findAccountById(2);
        account.setName("求求百度的offer");
        //3.执行方法
        as.updateAccount(account);
    }

    @Test
    public void testDelete(){
        //3.执行方法
        as.deleteAccount(3);
    }
@Test
    public void testAccount(){
        as.transfer("aaa","bbb",100f);
    }
}
