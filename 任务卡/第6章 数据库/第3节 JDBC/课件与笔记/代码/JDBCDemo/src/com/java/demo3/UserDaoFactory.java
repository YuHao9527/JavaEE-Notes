package com.java.demo3;

public class UserDaoFactory {
    public static BaseUserDao get(){
        return new MySqlUserDao();
    }
}
