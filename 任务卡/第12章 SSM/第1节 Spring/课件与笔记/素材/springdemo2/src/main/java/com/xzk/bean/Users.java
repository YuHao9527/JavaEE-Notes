package com.xzk.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Administrator
 * springDemo1
 * 面向对象面向君  不负代码不负卿
 */
@Component("u1")
@Scope(scopeName = "prototype")
public class Users {

    @Value("谢广坤")
    private String name;

    @PostConstruct    //等价于init-method属性
    public  void init(){
        System.out.println("初始化方法");
    }

    @PreDestroy  //等价于destroy-method属性
    public void destroy(){
        System.out.println("销毁方法");
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
