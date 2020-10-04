package com.yhp.dao;

import com.yhp.bean.Grade;
import com.yhp.bean.Student;

import java.util.List;

/**
 * Administrator
 * mybatis
 * 面向对象面向君  不负代码不负卿
 */
public interface GradeDao {
    //根据年级id查询年级和学生信息
    public Grade findbyGid(int id);
    //查询学生信息以及对应的年级信息
    public List<Student> findAllStudent();
}
