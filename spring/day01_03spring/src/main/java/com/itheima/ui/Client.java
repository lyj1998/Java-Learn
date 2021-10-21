package com.itheima.ui;
import com.itheima.dao.AccountDao;
import com.itheima.service.AccountService;
import com.itheima.service.impl.AccountServiceImpl;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import javax.annotation.Resources;

/**
 * 模拟一个表现层，用于调用业务层
 */
public class Client {
    /***
     * 获取spring的IOC核心容器，并根据id获取对象
     * @param args
     *
     * ApplicationContext的三个常用实现类：
     *     ClassPathXmlApplicationContext:它可以加载类路径下的配置文件，要求配置文件必须在类路径下。 不在的话，加载不了
        FileSystemXmlApplicationContext:它可以加载磁盘下任意路径下的配置文件（必须有访问权限）
       AnnotationConfigApplicationContext:它是用于读取注解创建容器的

     核心容器的两个接口引发出的问题：
     ApplicationContext: 单例对象使用
         它在创建核心容器时，创建对象采取的策略是采用立即加载的方式。也就是说，只要一堆取完配置文件马上就创建配置文件中的配置的对象
     BeanFactory: 多例对象适用
         它在构建核心容器时，创建对象采取的策略是采用延迟加载的方式。也就是说，什么时候根据id获取对象那个了，什么时候才真正的创建对象

     */    public static void main(String[] args) {
        //1.获取核心容器对象
        ApplicationContext ac = new  ClassPathXmlApplicationContext("bean.xml");
        //2.根据id获取Bean对象
        AccountService as = (AccountService) ac.getBean("accountService");
//        AccountDao dao = ac.getBean("accountDao", AccountDao.class);
        System.out.println(as);
//        System.out.println(dao);

        //---------------------BeanFactory-------------------------------
        Resource resources = new ClassPathResource("bean.xml");
        BeanFactory factory = new XmlBeanFactory(resources);
        AccountService service = (AccountService)factory.getBean("accountService");
        System.out.println(service);
       }
    }
