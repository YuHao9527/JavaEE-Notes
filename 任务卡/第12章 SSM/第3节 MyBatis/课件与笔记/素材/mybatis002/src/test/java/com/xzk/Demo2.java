package com.xzk;

import com.xzk.bean.Student;
import com.xzk.dao.StudentDao;
import com.xzk.dao.StudentDao2;
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
public class Demo2 {
    public static void main(String[] args) {
        SqlSession session = SqlSessionUtil.getSession();

      StudentDao2 studentDao = session.getMapper(StudentDao2.class);
      /*   Student student = new Student();
        student.setStudentNo("b1101");
        student.setStuName("abc");
        student.setAge(18);
        int i = studentDao.insertStu(student);
        session.commit();
        System.out.println("i="+i+",id="+student.getStudentId());*/

      /* Student student = new Student();
        student.setStudentId(120);
        student.setStudentNo("a1101");
        student.setStuName("张娜");
        student.setAge(20);
        int i = studentDao.updateStu(student);
        session.commit();
        System.out.println("i="+i);*/

     /*   List<Student> students = studentDao.findall();
        for (Student student : students) {
            System.out.println(student);
        }*/
      /*  List<Student> students = studentDao.getAllStudent();
        for (Student student : students) {
            System.out.println(student+","+student.getGrade().getGname());
        }*/

        int i = studentDao.insertParam("c101","广坤",50);
        session.commit();
        System.out.println("i="+i);
        SqlSessionUtil.closeSession();
    }
}
