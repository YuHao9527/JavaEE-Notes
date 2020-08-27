package com.java.demo3;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class MySqlUserDaoTest {

    @Test
    public void insert() {
        BaseUserDao dao = UserDaoFactory.get();
        boolean flag = dao.insert("yinpingguo", "123");
        System.out.println(flag?"成功":"失败");
    }
    //2.841 2.8 2.794   2.8
    @Test
    public void findByPassword() {
        BaseUserDao dao = UserDaoFactory.get();
        for(int i=0;i<1000;i++){
            boolean flag = dao.findByPassword("yinpingguo", "123");
            System.out.println(flag);
        }


    }

    //2.812     2.821   2.739   2.796
    @Test
    public void findByPassword2() {
        BaseUserDao dao = UserDaoFactory.get();
        for(int i=0;i<1000;i++){
            boolean flag = dao.findByPassword2("yinpingguo", "123");
            System.out.println(flag);
        }


    }
    @Test
    public void findAll() {
        BaseUserDao dao = UserDaoFactory.get();
        List<User> data = dao.findAll();
        System.out.println(data);
    }
}