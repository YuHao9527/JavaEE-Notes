package com.yhp;

import com.yhp.bean.Student;
import com.yhp.dao.StudentDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

/**
 * Administrator
 * mybatis
 * 面向对象面向君  不负代码不负卿
 */
public class TestDao {
    public static void main(String[] args) {
        try {
            //1.获得sqlSession对象
            Reader reader = Resources.getResourceAsReader("mybatis.xml");
            SqlSession session = new SqlSessionFactoryBuilder().build(reader).openSession();
            //2.得到要调用的方法
            StudentDao studentDao = session.getMapper(StudentDao.class);
            List<Student> studentList = studentDao.getall();
            for (Student student : studentList) {
                System.out.println(student);
            }
            //3.关闭资源
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
