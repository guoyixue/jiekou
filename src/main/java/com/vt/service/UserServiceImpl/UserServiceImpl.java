package com.vt.service.UserServiceImpl;
import com.vt.dao.UserDao;
import com.vt.entity.User;
import com.vt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    public UserDao userDao;


//    在数据库中添加用户
    @Override
    public int addUser(String username, String password,String session){
        User user = new User(username, password,session);
        int count = userDao.addUser(user);
        return count;
    }

//    在数据库中标记session
    @Override
    public int addUserS(String username, String password, String session) {
        User user = new User(username, password,session);
        userDao.addUserS(user);
        return 0;
    }

//    删除session
    @Override
    public int deleteSession(String username, String password,Object session){
        userDao.deleteSession(username,password,session);
        return 0;
    }

//    根据名字查找用户信息
    @Override
    public List<User>queryByName(String username){
        List<User> userList = userDao.queryByName(username);
        return userList;
    }
/*
    //根据用户名字密码更新session
    @Override
    public int upUser(String username, String password, String session) {
        User user = new User(username, password,session);
        int count = userDao.upUser(user);
        return count;
    }*/
}
