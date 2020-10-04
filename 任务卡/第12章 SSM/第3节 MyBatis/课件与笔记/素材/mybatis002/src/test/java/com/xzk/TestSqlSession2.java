package com.xzk;

import com.xzk.bean.Student;
import com.xzk.dao.StudentDao2;
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
            SqlSessionFactory build = builder.build(reader);
            //3.得到SqlSession
            SqlSession session = build.openSession();
            //4.操作sql
            StudentDao2 studentDao2 = session.getMapper(StudentDao2.class);
            List<Student> students = studentDao2.findall();
            session.close();
            System.out.println("---------------------------");
             SqlSession session2 = build.openSession();
             studentDao2 = session2.getMapper(StudentDao2.class);
             students = studentDao2.findall();
            session2.close();
            //6.关闭资源
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
