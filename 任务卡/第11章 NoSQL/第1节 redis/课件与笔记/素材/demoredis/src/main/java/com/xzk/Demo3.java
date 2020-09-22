package com.xzk;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * Administrator
 * demoredis
 * 面向对象面向君  不负代码不负卿
 */
public class Demo3 {
    public static void main(String[] args) throws IOException {
        //1.创建一个集合，保存集群信息
        Set set=new HashSet<HostAndPort>();
        set.add(new HostAndPort("192.168.197.132",7001));
        set.add(new HostAndPort("192.168.197.132",7002));
        set.add(new HostAndPort("192.168.197.132",7003));
        set.add(new HostAndPort("192.168.197.132",7004));
        set.add(new HostAndPort("192.168.197.132",7005));
        set.add(new HostAndPort("192.168.197.132",7006));
        //2.创建集群操作对象
        JedisCluster jedisCluster = new JedisCluster(set);
        //3.操作数据
        //jedis中的方法和redis中的指令是相同的
        jedisCluster.set("demo12","mydemo12");
        String demo12 = jedisCluster.get("demo12");
        System.out.println(demo12);
        //4.关闭资源
        jedisCluster.close();

    }
}
