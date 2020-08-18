package com.java.demo2;

import com.alibaba.fastjson.JSON;

import java.util.List;

public class Demo6 {
    public static void main(String[] args) {
        
        //1.    转换  : ["一二三","二三四","三四五"]
        List<String> strings = JSON.parseArray("[\"一二三\",\"二三四\",\"三四五\"]", String.class);
        System.out.println(strings.get(1));

    }
}
