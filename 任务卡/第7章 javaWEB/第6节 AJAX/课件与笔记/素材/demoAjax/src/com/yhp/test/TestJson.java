package com.yhp.test;

import com.yhp.bean.Users;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Administrator
 * demoAjax
 * 面向对象面向君  不负代码不负卿
 */

public class TestJson {
    public static void main(String[] args) {
        //1java->json
        Users users = new Users(1, "刘能");
        JSONObject jsonObject = JSONObject.fromObject(users);
        System.out.println(jsonObject);
        //json->java
        String str="{\"userId\":1,\"userName\":\"刘能\"}";
        JSONObject jsonObject1 = JSONObject.fromObject(str);
        Users u = (Users) JSONObject.toBean(jsonObject1, Users.class);
        System.out.println(u);
        //3.集合对象
        List list=new ArrayList();
        for (int i = 0; i < 5; i++) {
            list.add(new Users(i+10,"abc"+i));
        }
        JSONArray jsonArray = JSONArray.fromObject(list);
        System.out.println(jsonArray);
    }
}
