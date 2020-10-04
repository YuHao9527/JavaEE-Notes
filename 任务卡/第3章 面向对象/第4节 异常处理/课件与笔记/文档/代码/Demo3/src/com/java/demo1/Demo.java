package com.java.demo1;

import java.util.Scanner;

public class Demo {
    public static void main(String[] args){

        haha();
        System.out.println("程序执行完毕 , 正常结束");
    }

    private static void haha() {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入一个数字");
        int x = input.nextInt();
        System.out.println("请再输入一个数字");
        int y = input.nextInt();
        System.out.println(x / y);
        System.out.println("处理完毕");
        System.out.println("亲, 除数不能为0");
    }
}
