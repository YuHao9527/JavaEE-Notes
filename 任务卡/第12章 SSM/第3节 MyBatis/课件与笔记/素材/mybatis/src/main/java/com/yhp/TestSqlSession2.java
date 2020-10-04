package com.yhp;

import com.yhp.bean.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

/**
 * Administrator
 * mybatis
 * 面向对象面向君  不负代码不负卿
 */
public class TestSqlSession2 {
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
            List<Student> list = session.selectList("com.yhp.dao.StudentDao.getall");//方法参数是被调取的sql的完整路径=namespace+id
            session.close();
            System.out.println("---------------------------");
            SqlSession session2 = build.openSession();
            list = session2.selectList("com.yhp.dao.StudentDao.getall");
            //6.关闭资源
            session2.close();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
