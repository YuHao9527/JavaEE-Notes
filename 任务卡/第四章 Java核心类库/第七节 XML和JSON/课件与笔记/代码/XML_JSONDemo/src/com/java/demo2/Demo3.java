package com.java.demo2;

import com.google.gson.Gson;

import java.util.HashMap;
import java.util.List;

public class Demo3 {

    public static void main(String[] args) {
        //1.    创建Gson对象
        Gson g = new Gson();
        //2.    转换  :  {"id":"100","name":"金苹果","info":"种植苹果真辛苦","page":["锄禾日当午","汗滴禾下土","嘿嘿嘿嘿嘿"]}
        HashMap data = g.fromJson("{\"id\":\"100\",\"name\":\"金苹果\",\"info\":\"种植苹果真辛苦\",\"page\":[\"锄禾日当午\",\"汗滴禾下土\",\"嘿嘿嘿嘿嘿\"]}", HashMap.class);
        List page = (List) data.get("page");
        System.out.println(page.get(1));
    }
}
