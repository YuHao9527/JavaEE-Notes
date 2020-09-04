package com.yhp.bean;

/**
 * Administrator
 * demoAjax
 * 面向对象面向君  不负代码不负卿
 */

public class Users {
    private int userId;
    private String userName;

    @Override
    public String toString() {
        return "Users{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                '}';
    }

    public Users() {
    }

    public Users(int userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
