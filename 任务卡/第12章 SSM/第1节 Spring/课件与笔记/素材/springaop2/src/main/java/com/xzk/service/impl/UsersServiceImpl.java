package com.xzk.service.impl;

import com.xzk.dao.UsersDao;
import com.xzk.service.UsersService;

/**
 * Administrator
 * springaop2
 * 面向对象面向君  不负代码不负卿
 */
public class UsersServiceImpl implements UsersService {
    private UsersDao usersDao;

    public void test2() {
        System.out.println("userservice-test2");
    }

    public void setUsersDao(UsersDao usersDao) {
        this.usersDao = usersDao;
    }

    public void test1() {
        System.out.println("usersService---TEST1");
        //System.out.println(9/0);
        usersDao.test1();
    }
}
