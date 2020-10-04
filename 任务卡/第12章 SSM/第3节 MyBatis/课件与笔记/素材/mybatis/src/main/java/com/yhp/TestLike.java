package com.yhp;

import com.yhp.bean.Student;
import com.yhp.dao.StudentDao2;
import com.yhp.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.*;

/**
 * Administrator
 * mybatis
 * 面向对象面向君  不负代码不负卿
 */
public class TestLike {
    public static void main(String[] args) {
        SqlSession session = SqlSessionUtil.getSession();
        StudentDao2 studentDao2 = session.getMapper(StudentDao2.class);
     /*   Map map=new HashMap();
        map.put("stuname","张");
        map.put("sno","s1101");
        List<Student> students = studentDao2.findd(map);*/
        Student student1 = new Student();
        student1.setStuName("张");
        student1.setStudentNo("s1101");
        List<Student> students = studentDao2.finde(student1);
        for (Student student : students) {
            System.out.println(student);
        }
        SqlSessionUtil.closeSession();
    }
}
