package com.xzk;

import com.xzk.bean.Teacher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.*;

/**
 * Administrator
 * springDemo1
 * 面向对象面向君  不负代码不负卿
 */
public class Test5 {
    public static void main(String[] args) {

        //1.加载配置文件
        ApplicationContext app=new ClassPathXmlApplicationContext("application3.xml");
        Teacher t=(Teacher) app.getBean("t1");
        //2.得到对象中的信息
        Object[] objects = t.getObjects();
        for (Object object : objects) {
            System.out.println(object);
        }
        System.out.println("--------------------------");
        List list = t.getList();
        for (Object o : list) {
            System.out.println(o);
        }
        System.out.println("-----------------------------");
        Set set = t.getSet();
        for (Object o : set) {
            System.out.println(o);
        }
        System.out.println("-------------------------------");
        Map map = t.getMap();
        Set keySet = map.keySet();
        Iterator iterator = keySet.iterator();
        while(iterator.hasNext()){
          String key=(String)  iterator.next();
            System.out.println(key+","+map.get(key));
        }
        System.out.println("---------------------");
        Properties properties = t.getProperties();
        System.out.println(properties.getProperty("username"));
        System.out.println(properties.getProperty("password"));
    }
}
