package com.xzk;

import com.xzk.bean.Users;
import com.xzk.service.UsersService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Administrator
 * springDemo1
 * 面向对象面向君  不负代码不负卿
 */
public class Test6 {
    public static void main(String[] args) {
        ApplicationContext app=new ClassPathXmlApplicationContext("applicationioc.xml");
        UsersService uservice = (UsersService)app.getBean("uservice");
        uservice.insertUsers1(new Users());

    }
}
