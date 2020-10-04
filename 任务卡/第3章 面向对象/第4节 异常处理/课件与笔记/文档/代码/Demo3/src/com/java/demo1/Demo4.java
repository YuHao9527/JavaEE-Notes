package com.java.demo1;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 处理多异常的格式 3    常用
 */
public class Demo4 {
    public static void main(String[] args){

        haha();
        System.out.println("程序执行完毕 , 正常结束");
    }

    private static void haha() {
        try {
            Scanner input = new Scanner(System.in);
            System.out.println("请输入一个数字");
            int x = input.nextInt();
            System.out.println("请再输入一个数字");
            int y = input.nextInt();
            System.out.println(x / y);
            System.out.println("处理完毕");
        }catch(Exception e){//多态
            System.out.println("输入有误");
        }finally {
            //必然执行的异常统一处理出口
            //无论是否发生异常, finally必然执行.
            System.out.println("213123");
        }
    }
}
