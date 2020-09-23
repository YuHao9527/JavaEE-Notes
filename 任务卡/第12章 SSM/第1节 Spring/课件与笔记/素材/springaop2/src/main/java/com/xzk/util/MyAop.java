package com.xzk.util;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

import java.util.Date;

/**
 * Administrator
 * springaop2
 * 面向对象面向君  不负代码不负卿
 */
public class MyAop {

    //前置增强-调取目标方法之前执行
    public void before(JoinPoint joinPoint){
        System.out.println("日志开始");
        System.out.println(new Date()+"切点对象信息:"+joinPoint.getTarget().getClass().getSimpleName());
        System.out.println("方法信息:"+joinPoint.getSignature());
        System.out.println("参数信息:"+joinPoint.getArgs());
    }

    //后置增强-调取目标方法之后执行
    public void after(){
        System.out.println("日志结束");
    }

    public void myaroud(ProceedingJoinPoint joinPoint){
        System.out.println("环绕开始");
        try {
            joinPoint.proceed(); //调取目标方法
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("环绕结束");
    }

    //异常
    public void myex(){
        System.out.println("异常增强");
    }
    //最终增强-无论是否有异常都要执行
    public void aftera(){
        System.out.println("最终增强");
    }
}
