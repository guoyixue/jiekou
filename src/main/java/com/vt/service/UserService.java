package com.vt.service;
import com.vt.entity.User;

import java.util.List;

//前端可调用接口
public interface UserService {
//    注册
    int addUser(String username, String password, String session);
//    登录时标记session
    int addUserS(String username, String password, String session);
//    登陆时查找用户信息
    List<User>queryByName(String username);
//    int upUser(String username, String password, String session);
//    注销时删除用户登录状态（session）
    int deleteSession(String username, String password, Object session);
}