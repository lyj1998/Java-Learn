package com.itheimia.dao.impl;

import com.itheimia.dao.AccountDao;
import com.itheimia.domain.Account;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.itheimia.utils.ConnectionUtils;

import java.sql.SQLException;
import java.util.List;

@Repository("accountDao")
public class AccountDaoImpl implements AccountDao {
    @Autowired
    private QueryRunner runner;
    @Autowired
    private ConnectionUtils connectionUtils;

    public List<Account> findAllAccount() {
        try {
            return runner.query(connectionUtils.getThreadConnection(), "select * from account", new BeanListHandler<Account>(Account.class));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Account findAccountById(Integer accountId) {
        try {
            return runner.query(connectionUtils.getThreadConnection(), "select * from account where id = ?", new BeanHandler<Account>(Account.class), accountId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void saveAccount(Account account) {
        try {
            runner.update(connectionUtils.getThreadConnection(), "insert into account(name, money) values(?,?)", account.getName(), account.getMoney());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void updateAccount(Account account) {
        try {
            runner.update(connectionUtils.getThreadConnection(), "update account set name = ?, money = ? where id = ?", account.getName(), account.getMoney(), account.getId());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteAccount(Integer accountId) {
        try {
            runner.update(connectionUtils.getThreadConnection(), "delete from account where id = ?", accountId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Account findByName(String accountName) {
        try {
            List<Account> accounts = runner.query(connectionUtils.getThreadConnection(), "select * from account where name = ?", new BeanListHandler<Account>(Account.class), accountName);
            if (accounts == null || accounts.size() == 0) {
                return null;
            }
            if (accounts.size() > 1) {
                throw new RuntimeException("结果集不唯一，数据有问题");
            }
            return accounts.get(0);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
