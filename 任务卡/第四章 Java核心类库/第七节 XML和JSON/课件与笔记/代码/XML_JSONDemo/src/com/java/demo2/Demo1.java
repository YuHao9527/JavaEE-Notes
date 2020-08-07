package com.java.demo2;

import com.google.gson.Gson;
import jdk.swing.interop.SwingInterOpUtils;

public class Demo1 {

    public static void main(String[] args) {
        /*//1.    创建Gson对象
        Gson g = new Gson();
        //2.    转换
        Book b = new Book("100","金苹果","种植苹果真辛苦");
        String s = g.toJson(b);
        System.out.println(s);*/

        //1.    创建Gson对象
        //2.    转换
        Book b = new Book("100","金苹果","种植苹果真辛苦");
        String s = new Gson().toJson(b);
        System.out.println(s);
    }
}
