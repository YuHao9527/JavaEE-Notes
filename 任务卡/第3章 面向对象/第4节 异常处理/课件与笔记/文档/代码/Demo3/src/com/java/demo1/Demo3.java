package com.java.demo1;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 处理多异常的格式 2   了解
 */
public class Demo3 {
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
        }catch(InputMismatchException|ArithmeticException e){
            System.out.println("输入有误");
        }
    }
}
