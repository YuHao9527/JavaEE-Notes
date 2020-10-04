package com.yhp.dao;

import com.yhp.bean.Student;

import java.util.List;
import java.util.Map;

public interface StudentDao {
    //增删改查的方法
    public List<Student> getall();
    //主键查询
    public Student findById(int id);
    //新增
    public int insertStudent(Student student);
    //新增2
    public int insertStudent2(String name,String stuno);//错误
    //新增
    public int insertStudent3(Map map);//正确
    //查询studentidz中最大值，最小值，平均值
    public Map find();
}
