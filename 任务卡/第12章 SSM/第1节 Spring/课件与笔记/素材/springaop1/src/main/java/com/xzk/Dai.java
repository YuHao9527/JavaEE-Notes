package com.xzk;

import com.xzk.dao.UsersDao;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Administrator
 * springaop1
 * 面向对象面向君  不负代码不负卿
 */
public class Dai  implements InvocationHandler {
    private UsersDao usersDao;

    public Dai(UsersDao usersDao) {
        this.usersDao = usersDao;
    }

    //定义需要代理类做的事情
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("日志开始");
        //调取真实的方法
        Object invoke = method.invoke(usersDao, args);
        System.out.println("日志结束");
        return invoke;
    }
}
