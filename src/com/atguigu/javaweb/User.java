package com.atguigu.javaweb;

import java.util.List;

public class User {
    private String userName;
    private List<Authority> authorities;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<Authority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<Authority> authorities) {
        this.authorities = authorities;
    }

    public User(String userName, List<Authority> authorities) {
        this.userName = userName;
        this.authorities = authorities;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", authorities=" + authorities +
                '}';
    }
}
