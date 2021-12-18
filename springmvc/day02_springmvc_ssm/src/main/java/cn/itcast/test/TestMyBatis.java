package cn.itcast.test;

import cn.itcast.dao.AccountDao;
import cn.itcast.domain.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.*;
import org.aspectj.weaver.ast.Var;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.List;


public class TestMyBatis {
    @Test
    public void run() throws IOException {
        //加载配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //创建SqlSessionFactory对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //创建SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //获取到代理对象
        AccountDao dao = sqlSession.getMapper(AccountDao.class);
        List<Account> accountList = dao.findAll();
        for(Account account:accountList){
            System.out.println(account);
        }
    //关闭资源
        sqlSession.close();
        in.close();
    }
    @Test
    public void run2() throws IOException {
        Account account = new Account();
        account.setName("小金");
        account.setMoney(200.36);
        //加载配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //创建SqlSessionFactory对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //创建SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //获取到代理对象
        AccountDao dao = sqlSession.getMapper(AccountDao.class);
        dao.saveAccount(account);
        sqlSession.commit();
        //关闭资源
        sqlSession.close();
        in.close();
    }
}
