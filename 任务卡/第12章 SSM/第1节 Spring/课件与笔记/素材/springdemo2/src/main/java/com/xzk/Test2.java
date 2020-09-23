package com.xzk;

import com.xzk.bean.Users;
import com.xzk.service.UsersService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Administrator
 * springdemo2
 * 面向对象面向君  不负代码不负卿
 */
public class Test2 {
    public static void main(String[] args) {
        ApplicationContext app=new ClassPathXmlApplicationContext("application.xml");
        Users bean =(Users) app.getBean("u1");
        System.out.println(bean.getName());

        Users bean2 =(Users) app.getBean("u1");
        System.out.println(bean2);

    }
}
