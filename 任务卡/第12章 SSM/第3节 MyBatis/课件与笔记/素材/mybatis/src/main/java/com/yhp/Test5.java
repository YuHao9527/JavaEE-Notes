package com.yhp;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Administrator
 * mybatis
 * 面向对象面向君  不负代码不负卿
 */
public class Test5 {
    public static void main(String[] args) {
        try {
            //1.加载配置文件
            Reader reader = Resources.getResourceAsReader("mybatis.xml");
            //2.得到sqlSessionFactoryBuilder
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            SqlSessionFactory build = builder.build(reader,"a2");
            //3.得到SqlSession
            SqlSession session = build.openSession();
            //4.操作sql
            Map map = session.selectOne("com.yhp.dao.StudentDao.find");
            Set<Map.Entry> entrySet = map.entrySet();
            for (Map.Entry o : entrySet) {
                System.out.println(o);
            }
            //6.关闭资源
            session.close();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
