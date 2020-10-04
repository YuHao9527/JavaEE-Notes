package com.yhp.bean;

import java.io.Serializable;

/**
 * Administrator
 * mybatis
 * 面向对象面向君  不负代码不负卿
 */
//多方
public class Student implements Serializable {
    private int studentId; //属性名=列名
    private String studentNo;
    private String stuName;
    //private int stuAge;
    private int age;
    private Grade grade;

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getStudentId() {
        return studentId;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", studentNo='" + studentNo + '\'' +
                ", stuName='" + stuName + '\'' +
                ", stuAge='" + age + '\'' +
                '}';
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(String studentNo) {
        this.studentNo = studentNo;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }
}
