package com.yhp.dao;

import com.yhp.bean.Student;

import java.util.List;
import java.util.Map;

public interface StudentDao2 {
    //in 查询
    public List<Student> finda(List list);
    public List<Student> findb(int[] ids);
    public List<Student> findc(Map map);
    //模糊查询，根据学生姓名和编号进行查询
    public List<Student> findd(Map map);
    public List<Student> finde(Student stu);
    //查询id在1-5之间的数据
    public List<Student> findf(Map map);
}
