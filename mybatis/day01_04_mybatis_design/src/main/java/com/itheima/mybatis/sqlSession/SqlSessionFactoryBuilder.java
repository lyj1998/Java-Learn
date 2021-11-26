package com.itheima.mybatis.sqlSession;

import com.itheima.cfg.Configuration;
import com.itheima.mybatis.sqlSession.defaults.DefaultSqlSessionFactory;
import com.itheima.utils.XMLConfigBuilder;

import javax.swing.*;
import java.io.InputStream;

/**
 * 用于创建一个SqlSessionFactory对象
 */
public class SqlSessionFactoryBuilder {
    /**
     * 根据参数的字节输入流来构建一个SqlSessionFactory工厂
     * @param config
     * @return
     */
    public SqlSessionFactory build(InputStream config){
        Configuration configuration = XMLConfigBuilder.loadConfiguration(config);
        return new DefaultSqlSessionFactory(configuration);
    }
}
