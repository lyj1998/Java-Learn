package com.itheima.mybatis.sqlSession.defaults;

import com.itheima.cfg.Configuration;
import com.itheima.mybatis.sqlSession.SqlSession;
import com.itheima.mybatis.sqlSession.proxy.MapperProxy;
import com.itheima.utils.DataSourceUtil;

import java.lang.reflect.Proxy;
import java.sql.Connection;


/**
 * SqlSession接口的实现类
 */
public class DefaultSqlSession implements SqlSession {
    private Configuration cfg;
    private Connection conn;
    public DefaultSqlSession(Configuration cfg){
        this.cfg = cfg;
        this.conn = DataSourceUtil.getConnection(cfg);
    }
    /**
     * 用于创建代理对象
     * @param daoInterfaceClass  dao的接口字节码
     * @param <T>
     * @return
     */
    public <T> T getMapper(Class<T> daoInterfaceClass) {
        return (T)Proxy.newProxyInstance(daoInterfaceClass.getClassLoader(),
                new Class[]{daoInterfaceClass}, new MapperProxy(cfg.getMappers(), conn));
    }


    /**
     * 用于释放资源
     */
    public void close() {
        if(conn != null){
            try {
                conn.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }

    }
}
