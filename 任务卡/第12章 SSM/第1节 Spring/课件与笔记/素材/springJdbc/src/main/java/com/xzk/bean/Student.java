package com.xzk.bean;

/**
 * Administrator
 * springJdbc
 * 面向对象面向君  不负代码不负卿
 */
public class Student {
    private int studentId;
    private String studentNo;
    private String stuName;

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

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", studentNo='" + studentNo + '\'' +
                ", stuName='" + stuName + '\'' +
                '}';
    }
}
