package com.xzk.bean;

/**
 * Administrator
 * springDemo1
 * 面向对象面向君  不负代码不负卿
 */
public class Student {
    private String stuname;
    private int age;
    private char sex;

    public Student() {
    }

    public Student(String stuname, int age, char sex) {
        this.stuname = stuname;
        this.age = age;
        this.sex = sex;
    }

    public String getStuname() {
        return stuname;
    }

    public void setStuname(String stuname) {
        System.out.println("setStuName");
        this.stuname = stuname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Student{" +
                "stuname='" + stuname + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                '}';
    }
}
