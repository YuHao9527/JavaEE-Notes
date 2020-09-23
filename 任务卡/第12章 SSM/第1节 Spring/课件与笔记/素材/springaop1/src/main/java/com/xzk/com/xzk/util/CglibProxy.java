package com.xzk.com.xzk.util;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Administrator
 * springaop1
 * 面向对象面向君  不负代码不负卿
 */
public class CglibProxy implements MethodInterceptor {
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("日志开始-cglib");
        //目标方法(真实方法的调用)
        Object o1 = methodProxy.invokeSuper(o, objects);
        System.out.println("日志结束-cglib");
        return o1;
    }
}
