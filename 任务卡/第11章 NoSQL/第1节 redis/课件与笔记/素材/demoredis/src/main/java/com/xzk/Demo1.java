package com.xzk;

import redis.clients.jedis.Jedis;

/**
 * Administrator
 * demoredis
 * 面向对象面向君  不负代码不负卿
 */
public class Demo1 {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("192.168.197.132",6379);
        jedis.set("demo1","demo1101");
        String demo1 = jedis.get("demo1");
        System.out.println("demo1的变量值是:"+demo1);
    }
}
