package com.itheima.dao;

import com.itheima.domain.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * 在mybatis中 针对，CRUD一共有四个注释
 * @Select,@Insert,@Update,@Delete
 */

//开启二级缓存
@CacheNamespace(blocking = true)
public interface IUserDao {
//    @Select(value="select * from user")
//    @Results(id = "userMap", value={
//       @Result(id=true, column = "id", property = "userID"),
//       @Result( column = "username", property = "userName"),
//       @Result(column = "sex", property = "userSex"),
//       @Result( column = "address", property = "userAddress"),
//       @Result( column = "birthday", property = "userBirthday"),
////       @Result(property = "account" ,column="id",
////               many = @Many(select = "com.itheima.dao.IAccountDao.findAccountByUid",
////               fetchType = FetchType.LAZY))
//    })
//    List<User> findAll();
@Select("select * from user")
@Results(id="userMap",value={
        @Result(id=true,column = "id",property = "userId"),
        @Result(column = "username",property = "userName"),
        @Result(column = "address",property = "userAddress"),
        @Result(column = "sex",property = "userSex"),
        @Result(column = "birthday",property = "userBirthday"),
        @Result(property = "accounts",column = "id",
                many = @Many(select = "com.itheima.dao.IAccountDao.findAccountByUid",
                        fetchType = FetchType.LAZY))
})
List<User> findAll();



    @Select("select * from user where id = #{id}")
    @ResultMap("userMap")
    User findById(Integer Id);
    @Select(value = "select * from user where username  like #{username}")
    @ResultMap("userMap")
    List<User> findByName(String username);
}
