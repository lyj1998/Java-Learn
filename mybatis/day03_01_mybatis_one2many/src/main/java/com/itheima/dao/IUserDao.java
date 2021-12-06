package com.itheima.dao;

import com.itheima.domain.User;
import java.util.List;

public interface IUserDao {
    /**
     * 同时获取到所有人的信息
     * @return
     */
    List<User> findAll();
    User findById(Integer userId);
}
