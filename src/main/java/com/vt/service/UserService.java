package com.vt.service;
import com.vt.entity.User;

import java.util.List;

public interface UserService {
    int addUser(String username, String password, String session);
    List<User>queryByName(String username);

}