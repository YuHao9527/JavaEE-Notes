package com.xzk.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

/**
 * Administrator
 * mybatis
 * 面向对象面向君  不负代码不负卿
 */
public class SqlSessionUtil {
    private static ThreadLocal<SqlSession>threadLocal=new ThreadLocal<SqlSession>();
    private static SqlSessionFactory sqlSessionFactory;

    static {
        try {
            Reader resourceAsReader = Resources.getResourceAsReader("mybatis.xml");
            sqlSessionFactory= new SqlSessionFactoryBuilder().build(resourceAsReader,"a2");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static SqlSession getSession(){
        SqlSession session = threadLocal.get();
        if(session==null){
            session = sqlSessionFactory.openSession();
            threadLocal.set(session);
        }
        return session;
    }
    public static void closeSession(){
        SqlSession session = threadLocal.get();
        if(session!=null){
            session.close();
            threadLocal.remove();
        }
    }

}
