package com.itheima.test;

import com.itheima.dao.IUserDao;
import com.itheima.domain.User;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class AnnotationCRUDTest {
    private InputStream in;
    private SqlSessionFactory factory;
    private SqlSession sqlSession;
    private IUserDao userDao;
    @Before
    public void init() throws IOException {
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        factory = new SqlSessionFactoryBuilder().build(in);
        sqlSession = factory.openSession();
         userDao = sqlSession.getMapper(IUserDao.class);
    }
    @After
    public void destory() throws IOException {
        sqlSession.commit();
        sqlSession.close();
        in.close();
    }

    @Test
    public void findAll(){
        List<User> users = userDao.findAll();
        for(User user: users){
            System.out.println(user);
            System.out.println(user.getAccounts());
        }
    }
    @Test
    public void testFindById(){
        User user = userDao.findById(43);
        System.out.println(user);
    }
    @Test
    public void testFindByName(){
        List<User> users = userDao.findByName("%王%");
        for(User user: users){
            System.out.println(user);
        }
    }
}
