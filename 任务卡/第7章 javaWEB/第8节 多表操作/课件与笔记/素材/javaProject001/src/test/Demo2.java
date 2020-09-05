package test;

import bean.Grade;
import bean.Student;
import dao.impl.GradeDaoImpl;

import java.util.List;

public class Demo2 {
    public static void main(String[] args) {
        GradeDaoImpl gradeDao = new GradeDaoImpl();
        List<Student> studentList = gradeDao.findAll();
        for (Student student : studentList) {
            System.out.println(student.getStuName()+"\t"+student.getGrade().getGname());
        }
    }
}
