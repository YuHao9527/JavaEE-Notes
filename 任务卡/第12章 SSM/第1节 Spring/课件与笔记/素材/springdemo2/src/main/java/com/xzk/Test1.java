package com.xzk;

import com.xzk.bean.Users;
import com.xzk.service.UsersService;
import com.xzk.service.impl.UsersServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Administrator
 * springdemo2
 * 面向对象面向君  不负代码不负卿
 */
public class Test1 {
    public static void main(String[] args) {
        ApplicationContext app=new ClassPathXmlApplicationContext("application.xml");
        UsersService bean =(UsersService) app.getBean("uservice");
        bean.insertUsers1(new Users());

    }
}
