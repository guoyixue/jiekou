package com.vt.dao;

import com.vt.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

//数据库接口
public interface UserDao {

//注册时在数据库写入用户名和密码，session默认为null
    @Insert("INSERT INTO user(username, password,session) VALUES(#{user.username},#{user.password},#{user.session})")
    int addUser(@Param("user") User user);
//登陆时在数据库写入用户名和密码，标记一个session
    @Insert("INSERT INTO usersession(username, password,session) VALUES(#{username},#{password},#{session})")
    int addUserS(@Param("user") User user);
//在数据库中根据用户名获取用户信息
    @Select("SELECT * FROM user WHERE username = #{username}")
    List<User>queryByName(@Param("username") String username);
//删除用户session信息
    @Delete("DELETE  FROM mybatis.usersession WHERE username = #{username} AND password =#{password} AND session = #{session}")
    int deleteSession(@Param("username")String username,@Param("password") String password,@Param("session")Object session);

}
