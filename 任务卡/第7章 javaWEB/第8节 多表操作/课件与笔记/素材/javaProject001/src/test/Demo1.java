package test;

import bean.Grade;
import bean.Student;
import dao.impl.GradeDaoImpl;

import java.util.List;

public class Demo1 {
    public static void main(String[] args) {
        GradeDaoImpl gradeDao = new GradeDaoImpl();
        Grade grade= gradeDao.findById(1);
        System.out.println(grade.getGname());
        List<Student> studentList = grade.getStudentList();
        for (Student student : studentList) {
            System.out.println("\t"+student.getStuName());
        }
    }
}
