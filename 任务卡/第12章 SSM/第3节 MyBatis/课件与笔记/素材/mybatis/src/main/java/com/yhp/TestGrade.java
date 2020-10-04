package com.yhp;

import com.yhp.bean.Grade;
import com.yhp.bean.Student;
import com.yhp.dao.GradeDao;
import com.yhp.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * Administrator
 * mybatis
 * 面向对象面向君  不负代码不负卿
 */
public class TestGrade {
    public static void main(String[] args) {
        SqlSession session = SqlSessionUtil.getSession();
        GradeDao mapper = session.getMapper(GradeDao.class);
       /* Grade grade = mapper.findbyGid(2);
        System.out.println(grade.getGname());
        List<Student> studentList = grade.getStudentList();
        for (Student student : studentList) {
            System.out.println(student);
        }*/
        List<Student> allStudent = mapper.findAllStudent();
        for (Student student : allStudent) {
            System.out.println(student+","+student.getGrade().getGname());
        }
        SqlSessionUtil.closeSession();
    }
}
