package com.xzk;

import com.xzk.bean.Grade;
import com.xzk.bean.Student;

/**
 * Administrator
 * mybatis002
 * 面向对象面向君  不负代码不负卿
 */
public class TestLombok {
    public static void main(String[] args) {

        Student student = new Student();
        student.getGrade();
        Student student1 = new Student(1, "", "", 19,new Grade());
    }
}
