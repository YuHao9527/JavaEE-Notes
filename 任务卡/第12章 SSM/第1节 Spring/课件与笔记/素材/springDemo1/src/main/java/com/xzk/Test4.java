package com.xzk;

import com.xzk.bean.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Administrator
 * springDemo1
 * 面向对象面向君  不负代码不负卿
 */
public class Test4 {
    public static void main(String[] args) {
        //从配置文件中得到已经创建好的对象
        //1.加载配置文件
        ApplicationContext app=new ClassPathXmlApplicationContext("application2.xml");
        Student stu3 = (Student) app.getBean("stu3");
        System.out.println(stu3);


    }
}
