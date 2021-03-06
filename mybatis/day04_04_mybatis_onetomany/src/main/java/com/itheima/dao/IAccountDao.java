package com.itheima.dao;

import com.itheima.domain.Account;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface IAccountDao {
    /**
     * 查询所有账户以及对应的用户的信息
     * @return
     */
    @Select(value = "select * from account")
    @Results(id="accountMap" ,value={
      @Result(id = true, property = "id", column = "id"),
      @Result(property = "uid", column = "uid"),
      @Result(property = "money", column = "money"),
      @Result(property = "user", column = "uid", one = @One(select = "com.itheima.dao.IUserDao.findById", fetchType = FetchType.EAGER))
    })
    List<Account> findAll();



    @Select("select * from account where uid = #{userId}")
    List<Account> findAccountByUid(Integer userId);
}
