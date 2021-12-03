package com.itheima.dao;

import com.itheima.domain.QueryVo;
import com.itheima.domain.User;
import java.util.List;

public interface IUserDao {
    List<User> findAll();
    void saveUser(User user);
    void updateUser(User user);
    void deleteUser(Integer userId);
    User findById(Integer userId);

    /**
     * 模糊查询用户信息
     */
    List<User> findByName(String username);
    /**
     * 获取用户的总记录条数
     */
    int findTotal();

    /**
     * 由多个对象组合成查询条件进行查询
     */
    List<User> findByVo(QueryVo Vo);

}
