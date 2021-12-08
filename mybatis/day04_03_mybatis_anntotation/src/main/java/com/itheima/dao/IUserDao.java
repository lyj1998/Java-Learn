package com.itheima.dao;

import com.itheima.domain.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * 在mybatis中 针对，CRUD一共有四个注释
 * @Select,@Insert,@Update,@Delete
 */
public interface IUserDao {
    @Select(value="select * from user")
    List<User> findAll();
    @Update(value="update user set username=#{username}, sex=#{sex}, birthday=#{birthday} where id =#{id}")
    void updateUser(User user);
    @Insert(value="insert into user(username,address,sex,birthday) values(#{username},#{address},#{sex},#{birthday})")
    void saveUser(User user);
    @Delete(value="delete from user where id=#{id}")
    void deleteUser(Integer Id);
    @Select("select * from user where id = #{id}")
    User findById(Integer Id);
    @Select(value = "select * from user where username  like #{username}")
    List<User> findByName(String username);

    @Select("select count(*) from user")
    int findTotal();
}
