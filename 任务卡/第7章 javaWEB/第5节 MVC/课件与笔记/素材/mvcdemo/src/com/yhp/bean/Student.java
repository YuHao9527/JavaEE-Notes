package com.yhp.bean;

/**
 * Administrator
 * mvcdemo
 * 面向对象面向君  不负代码不负卿
 */
//实体类（javabean）
//类名=表名  列名=属性名
public class Student {
    private int studentId;
    private String studentNo;
    private String stuName;
    private int StuAge;

    public Student() {
    }

    public Student(int studentId, String studentNo, String stuName, int stuAge) {
        this.studentId = studentId;
        this.studentNo = studentNo;
        this.stuName = stuName;
        StuAge = stuAge;
    }

    public int getStudentId() {
        return studentId;
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

    public int getStuAge() {
        return StuAge;
    }

    public void setStuAge(int stuAge) {
        StuAge = stuAge;
    }
}
