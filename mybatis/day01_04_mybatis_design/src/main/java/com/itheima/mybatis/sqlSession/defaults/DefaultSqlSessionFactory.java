package com.itheima.mybatis.sqlSession.defaults;

import com.itheima.cfg.Configuration;
import com.itheima.mybatis.sqlSession.SqlSession;
import com.itheima.mybatis.sqlSession.SqlSessionFactory;

/**
 * SqlSessionFactory接口的实现类
 */
public class DefaultSqlSessionFactory implements SqlSessionFactory {
    /**
     * 用于创建一个新的操作数据库对象
     * @return
     */
    private Configuration cfg;
    public DefaultSqlSessionFactory(Configuration cfg){
        this.cfg = cfg;
    }

    /**
     * 用于创建一个新的操作数据库对象
     * @return
     */
    public SqlSession openSession() {
        return new DefaultSqlSession(cfg);
    }
}
