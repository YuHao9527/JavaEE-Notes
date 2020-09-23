package com.xzk;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Administrator
 * springDemo1
 * 面向对象面向君  不负代码不负卿
 */
public class Test3 {
    public static void main(String[] args) {
        //从配置文件中得到已经创建好的对象
        //1.加载配置文件
        ApplicationContext app=new ClassPathXmlApplicationContext("application.xml");
      //  Object u2 = app.getBean("u2");
        Object u3 = app.getBean("u3");
        System.out.println("u3="+u3);
        Object u5= app.getBean("u5");
        System.out.println("u5="+u5);
    }
}
