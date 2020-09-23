package com.xzk;

import com.xzk.service.UsersService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Administrator
 * springaop2
 * 面向对象面向君  不负代码不负卿
 */
public class Test1 {
    public static void main(String[] args) {
        //需求:在service层调取test1()方法时做增强
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("application.xml");
        UsersService usersService=(UsersService) applicationContext.getBean("uservice");
       // usersService.test1();
        usersService.test2();
    }
}
