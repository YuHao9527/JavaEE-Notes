package com.java.demo2;

import com.google.gson.Gson;

public class Demo2 {

    public static void main(String[] args) {
        //1.    创建Gson对象
        Gson g = new Gson();
        //2.    转换  :  {"id":"100","name":"金苹果","info":"种植苹果真辛苦"}
        Book b = g.fromJson("{\"id\":\"100\",\"name\":\"金苹果\",\"info\":\"种植苹果真辛苦\"}", Book.class);
        System.out.println(b.getId());
    }
}
