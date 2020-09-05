package dao;

import bean.Grade;
import bean.Student;

import java.util.List;

public interface GradeDao {
    //查询某个年级信息(要求同时查询出学生的信息)
    public Grade findById(int gid);
    //查询学生的信息(包含年级信息)
    public List<Student> findAll();
}
