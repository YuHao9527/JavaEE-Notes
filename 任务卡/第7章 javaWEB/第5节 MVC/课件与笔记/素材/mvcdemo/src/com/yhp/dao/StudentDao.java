package com.yhp.dao;

import com.yhp.bean.Student;

import java.util.List;

//定义操作数据库的方法
public interface StudentDao {
    //查询所有的学生
    public List<Student> getall();

}
