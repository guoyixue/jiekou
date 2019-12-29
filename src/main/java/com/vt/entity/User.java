package com.vt.entity;
//用户类
public class User {
    public String username;
    public String password;
    public String session;

    public User(String username, String password, Object session){}
    public User(String username, String password,String session){
        this.username = username;
        this.password = password;
        this.session =session;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String name) {
        this.username = name;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getSession() {
        return session;
    }
    public void setSession(String session) {
        this.session = session;
    }
}

