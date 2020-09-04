package com.java.bean;

import java.util.Objects;

/**
 * @ClassName Student
 * @Description 学生类
 * @Author 0715-YuHao
 * @Date 2020/9/4 23:18
 * @Version 1.0
 */
public class Student {
    private String name;
    private String info;
    private int fansNum;

    public Student() {
    }

    public Student(String name, String info, int fansNum) {
        this.name = name;
        this.info = info;
        this.fansNum = fansNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getFansNum() {
        return fansNum;
    }

    public void setFansNum(int fansNum) {
        this.fansNum = fansNum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(name, student.name) &&
                Objects.equals(info, student.info);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, info);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", info='" + info + '\'' +
                ", fansNum=" + fansNum +
                '}';
    }
}
