package com.xzk;

import com.xzk.bean.Student;
import com.xzk.dao.StudentDao;
import com.xzk.dao.impl.StudentDaoImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Administrator
 * springJdbc
 * 面向对象面向君  不负代码不负卿
 */
public class Demo2 {
    public static void main(String[] args) {
        ApplicationContext app=new ClassPathXmlApplicationContext("spring.xml");
        StudentDao dao=(StudentDao) app.getBean("studentDao");
       Student student = new Student();
        student.setStudentId(9);
        student.setStudentNo("stu009");
        student.setStuName("小丽9");
        int insert = dao.insert(student);
        System.out.println(insert);
        /*Student student = dao.findbyid(2);
        System.out.println(student);*/
       /* List<Student> students = dao.findall();
        for (Student student : students) {
            System.out.println(student);
        }*/

    }
}
