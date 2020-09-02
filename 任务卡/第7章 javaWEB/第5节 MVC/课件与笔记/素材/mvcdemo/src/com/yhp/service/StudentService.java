package com.yhp.service;

import com.yhp.bean.Student;

import java.util.List;

//定义操作数据库的方法
public interface StudentService {
    //查询所有的学生
    public List<Student> getall();

}
