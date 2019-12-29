package com.vt.controller;
import com.vt.entity.Response;
import com.vt.entity.User;
import com.vt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    //注册
    @RequestMapping(value = "register", method = RequestMethod.POST)
    public Response register(@RequestBody Map<String, String> person) {
        String username = person.get("username");
        String password = person.get("password");
        if (username != null && password != null) {
            List<User> users = userService.queryByName(username);
            if (users.size() == 0) {
                String session = "null";
                int count = userService.addUser(username, password, session);
                if (count > 0) {
                    return new Response("注册成功", 1, true);
                } else {
                    return new Response("注册失败", -1, false);
                }
            } else {
                return new Response("注册失败：用户名已存在", -1, false);
            }
        } else {
            return new Response("注册失败：用户名、密码不能为空", -1, false);
        }
    }


    //登录
    @RequestMapping(value = "login",method = RequestMethod.POST)
    public Response login(@RequestBody Map<String, String> person) {
        String username = person.get("username");
        String password = person.get("password");

        if (username != null && password != null) {
            List<User> users = userService.queryByName(username);
            if (users.size() == 0) {
                return new Response("登录失败：用户名不存在", -1, false);
            } else {
                if (users.get(0).getPassword().equals(password)) {
                    String session = "true";
                    userService.addUserS(username, password, session);
                    return new Response("登录成功", 1, true);
                } else {
                    return new Response("登录失败：密码错误", -1, false);
                }
            }
        } else {
            return new Response("登录失败：用户名密码不能为空", -1, false);
        }
    }



    //注销
    @RequestMapping(value = "logout", method = RequestMethod.POST)
    public Response logout(@RequestBody Map<String, String> person) {
        String username = person.get("username");
        String password = person.get("password");
        Object session = "true";
        userService.deleteSession(username,password,session);
        return new Response("注销成功", 1, true);
    }
}
