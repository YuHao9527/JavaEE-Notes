package com.xzk.com.xzk;

import com.xzk.com.xzk.bean.Users;
import com.xzk.com.xzk.util.CglibProxy;
import net.sf.cglib.proxy.Enhancer;

/**
 * Administrator
 * springaop1
 * 面向对象面向君  不负代码不负卿
 */
public class TestCglib {
    public static void main(String[] args) {
        //1.创建真实对象
        Users users = new Users();
        //2.创建代理对象
       Enhancer enhancer = new Enhancer();
       enhancer.setSuperclass(users.getClass());
       enhancer.setCallback(new CglibProxy());
       Users o = (Users) enhancer.create();//代理对象
       o.test1();


    }
}
