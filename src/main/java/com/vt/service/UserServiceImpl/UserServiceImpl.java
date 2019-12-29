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
    public int addUser(String username,String password){
        User user = new User(username, password);
        int count = userDao.addUser(user);
        return count;
    }

//    根据名字查找用户信息
    @Override
    public List<User>queryByName(String username){
        List<User> userList = userDao.queryByName(username);
        return userList;
    }
}
