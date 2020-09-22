package com.xzk;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Administrator
 * demoredis
 * 面向对象面向君  不负代码不负卿
 */
public class Demo2 {
    public static void main(String[] args) {
        //1.创建连接池配置的工具类对象
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxIdle(10);//jedis连接的空闲数
        jedisPoolConfig.setMaxTotal(20);//总得连接数
        JedisPool jedisPool=null;
        Jedis jedis=null;
        try {
            //2.创建连接池对象
            jedisPool = new JedisPool(jedisPoolConfig,"192.168.197.132",6379);
            //3.获得jedis资源
            jedis = jedisPool.getResource();
            //4.操作数据
            jedis.set("stu1","student1");
            String stu1 = jedis.get("stu1");
            System.out.println("stu1="+stu1);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //5.关闭资源
            if(jedis!=null){
                jedis.close();
            }
            if(jedisPool!=null){
                jedisPool.close();
            }
        }

    }
}
