package com.java.demo2;

import com.alibaba.fastjson.JSON;

public class Demo5 {
    public static void main(String[] args) {
        
        //1.    转换  : {"id":"1002","info":"床前明月光，地上鞋一堆。床上我杰哥，喊十块钱一双。","name":"唐诗三百首"}
        Book book = JSON.parseObject("{\"id\":\"1002\",\"info\":\"床前明月光，地上鞋一堆。床上我杰哥，喊十块钱一双。\",\"name\":\"唐诗三百首\"}", Book.class);
        System.out.println(book.getId());

    }
}
