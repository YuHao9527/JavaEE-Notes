package com.xzk;

import com.xzk.bean.Users;
import com.xzk.service.UsersService;
import com.xzk.service.impl.UsersServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Administrator
 * springDemo1
 * 面向对象面向君  不负代码不负卿
 */
public class Test1 {
    public static void main(String[] args) {
        //从配置文件中得到已经创建好的对象
        //1.加载配置文件
        ApplicationContext app=new ClassPathXmlApplicationContext("application.xml");
        //2.通过getBean("对象的id")这个方法得到指定对象
        UsersService  uservice = (UsersService) app.getBean("uservice");

        uservice.insertUsers1(new Users());

    }
}
