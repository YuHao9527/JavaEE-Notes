package com.xzk;

import com.xzk.bean.Student;
import com.xzk.dao.StudentDao;
import com.xzk.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Administrator
 * mybatis002
 * 面向对象面向君  不负代码不负卿
 */
public class Demo1 {
    public static void main(String[] args) {
        SqlSession session = SqlSessionUtil.getSession();

        StudentDao studentDao = session.getMapper(StudentDao.class);
       /* Student student = new Student();
        student.setStudentNo("a1101");
        student.setStuName("abc");
        student.setAge(18);
        int i = studentDao.insertStu(student);
        session.commit();
        System.out.println("i="+i+",id="+student.getStudentId());*/

       /* Student student = new Student();
        student.setStudentId(119);
        student.setStudentNo("a1101");
        student.setStuName("张娜");
        student.setAge(20);
        int i = studentDao.updateStu(student);
        session.commit();
        System.out.println("i="+i);*/
/*
        List<Student> students = studentDao.findall();
        for (Student student : students) {
            System.out.println(student);
        }*/
     /*   int i = studentDao.deleteStu(119);
        session.commit();
        System.out.println("i="+i);*/

     /*   int i = studentDao.totalCount();
        System.out.println("total="+i);*/
        Map map = studentDao.total2();
        Set<Map.Entry> set = map.entrySet();
        for (Map.Entry entry : set) {
            System.out.println(entry);
        }
        SqlSessionUtil.closeSession();
    }
}
