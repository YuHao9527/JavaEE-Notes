package com.xzk.util;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * Administrator
 * springaop2
 * 面向对象面向君  不负代码不负卿
 */
public class BeforeAop implements MethodBeforeAdvice {
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("特殊的前置增强");
        System.out.println("目标方法:"+method.getName());
        System.out.println("参数:"+objects);
        System.out.println("对象:"+o);
    }
}
