package com.itheima.jdbc;

import com.itheima.domain.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * JdbcTemplate的最基本用法
 */
public class JdbcTemplateDemo2 {
    public static void main(String[] args) {
        //1.获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.获取对象
        JdbcTemplate jt = ac.getBean("jdbcTemplate",JdbcTemplate.class);
//        //3.执行操作
//        jt.execute("insert into account(name,money)values('ddd',222)");
//        //增加
//       jt.update("insert into account(name,money)values(?,?)","eee",77f);
//        //删除
//        jt.update("delete from account where id = ?",4);
//        //更新
//        jt.update("update account set money = ?,name=?  where id= ?", 66f,"test",3);
        //查询所有
//        List<Account> accounts  = jt.query("select * from account where money>?", new AccountRowMapper(),1000f);
//        for(Account account:accounts){
//            System.out.println(accounts);
//        }
//        List<Account> accounts = jt.query("select * from account where money >?", new BeanPropertyRowMapper<Account>(Account.class), 100f);
//        for(Account account:accounts) {
//            System.out.println(account);
//        }
        //查询一个
        List<Account> accounts1 = jt.query("select * from account where id = ?",new BeanPropertyRowMapper<Account>(Account.class),1);
        System.out.println(accounts1.isEmpty()?"没有内容":accounts1.get(0));
        //返回一行一列(使用聚合函数，但不加group by子句)
        int sum  = jt.queryForObject("select count(*) from account where money > ?",Integer.class,1000f);
        System.out.println(sum);
        /*
        //准备数据源，spring的内置数据源
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/eesy");
        ds.setUsername("root");
        ds.setPassword("root");
        //1.创建JdbcTemplate对象
        JdbcTemplate jt = new JdbcTemplate();
        //2.给jt设置数据源
       jt.setDataSource(ds);
        //2.执行操作
        jt.execute("insert into account(name,money)values('ccc',1000)");
        */
    }
}

/**
 * 定义Account的封装策略
 */
class AccountRowMapper implements RowMapper<Account>{
    /**
     * 把结果集中的数据封装到Account中，然后由spring把每个Account加到集合中
     * @param resultSet
     * @param i
     * @return
     * @throws SQLException
     */
    public Account mapRow(ResultSet resultSet, int i) throws SQLException {
          Account account = new Account();
          account.setId(resultSet.getInt("id"));
          account.setName(resultSet.getString("name"));
          account.setMoney(resultSet.getFloat("money"));
          return account;
    }
}
