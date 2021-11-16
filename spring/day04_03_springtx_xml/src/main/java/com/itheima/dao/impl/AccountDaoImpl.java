package java.com.itheima.dao.impl;


import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.itheima.dao.AccountDao;
import com.itheima.domain.Account;
import java.util.List;

public class AccountDaoImpl implements AccountDao {
    private JdbcTemplate jdbcTemplate;
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public Account findById(Integer id) {
        List<Account> list = jdbcTemplate.query("select * from account where id = ?", new BeanPropertyRowMapper<Account>(Account.class), id);
        return list.size()>0?list.get(0):null;
    }

    public Account findByName(String accountName) {
        List<Account> list = jdbcTemplate.query("select * from account where name= ?", new BeanPropertyRowMapper<Account>(Account.class), accountName);
        if(list.isEmpty()){
            return null;
        }
        if(list.size()>1){
            throw new RuntimeException("结果集不唯一");
        }
        return list.get(0);
    }

    public void updateAccount(Account account) {
jdbcTemplate.update("update account set name = ?,money = ? where id = ?", account.getMoney(),account.getMoney(),account.getId());
    }
}
