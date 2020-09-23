package com.xzk.dao;

import com.xzk.bean.Student;

import java.util.List;

public interface StudentDao {
    //新增
    public int insert(Student student);
    //查询单行
    public Student findbyid(int id);
    //查询多行
    public List<Student> findall();
}
