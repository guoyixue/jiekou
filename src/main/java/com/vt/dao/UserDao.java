package com.vt.dao;

import com.vt.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;


public interface UserDao {

    @Insert("INSERT INTO user(username, password,session) VALUES(#{user.username},#{user.password},#{user.session})")
    int addUser(@Param("user") User user);

    @Insert("INSERT INTO usersession(username, password,session) VALUES(#{username},#{password},#{session})")
    int addUserS(@Param("user") User user);

    @Select("SELECT * FROM user WHERE username = #{username}")
    List<User>queryByName(@Param("username") String username);

    @Delete("DELETE  FROM mybatis.usersession WHERE username = #{username} AND password =#{password} AND session = #{session}")
    int deleteSession(@Param("username")String username,@Param("password") String password,@Param("session")Object session);

}
