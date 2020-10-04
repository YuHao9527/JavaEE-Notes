package com.yhp;

import java.util.*;

/**
 * Administrator
 * mybatis
 * 面向对象面向君  不负代码不负卿
 */
public class TestThread {
    private ThreadLocal<String> threadLocal=new ThreadLocal<String>();
    private List<String> list=new ArrayList<String>();
    class A extends  Thread{
        @Override
        public void run() {
           //存值
            System.out.println("A线程开始存值");
            threadLocal.set("thread内容");
            list.add("list内容");
            System.out.println("A---threadLocal="+threadLocal.get());
        }
    }
    class B extends  Thread{
        @Override
        public void run() {
            //  取值
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("B线程取数据");
            System.out.println("b---threadLocal="+threadLocal.get());
            System.out.println("list="+list.get(0));
        }
    }

    public static void main(String[] args) {
        TestThread testThread = new TestThread();
        TestThread.A a=testThread.new A();
        TestThread.B b=testThread.new B();
        a.start();
        b.start();
    }
}
