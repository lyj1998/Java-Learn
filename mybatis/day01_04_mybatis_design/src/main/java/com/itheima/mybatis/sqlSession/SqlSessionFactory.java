package com.itheima.mybatis.sqlSession;

/**
 * 用于打开一个新的SqlSession对象
 */
public interface SqlSessionFactory {
      SqlSession openSession();
}
