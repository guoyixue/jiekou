package com.vt.dao;

import com.vt.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

//数据库接口
public interface UserDao {

//注册时在数据库写入用户名和密码
    @Insert("INSERT INTO user(username, password) VALUES(#{user.username},#{user.password})")
    int addUser(@Param("user") User user);
//在数据库中根据用户名获取用户信息
    @Select("SELECT * FROM user WHERE username = #{username}")
    List<User>queryByName(@Param("username") String username);
}
