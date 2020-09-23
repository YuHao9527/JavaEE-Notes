package com.xzk;

import com.xzk.dao.UsersDao;
import com.xzk.dao.impl.UsersDaoImpl;

import java.lang.reflect.Proxy;

/**
 * Administrator
 * springaop1
 * 面向对象面向君  不负代码不负卿
 */
public class Test1 {
    public static void main(String[] args) {
        UsersDao usersDao = new UsersDaoImpl();
        //又代理对象调取方法
        Dai dai = new Dai(usersDao);
        //生成代理对象
        UsersDao o =(UsersDao) Proxy.newProxyInstance(usersDao.getClass().getClassLoader(), usersDao.getClass().getInterfaces(), dai);
        //由代理对象调取方法
        o.test1();
    }
}
