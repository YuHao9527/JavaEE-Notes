package com.java.service;

import com.java.bean.Student;

import java.util.List;

/**
 * @InterfaceName StudentService
 * @Description 定义操作数据库的方法
 * @Author 0715-YuHao
 * @Date 2020/9/4 23:22
 * @Version 1.0
 */
public interface StudentService {
    /**
     * @Author 0715-YuHao
     * @Description 查询所有学生
     * @Date 23:24 2020/9/4
     * @Param []
     * @return java.util.List<com.java.bean.Student>
     **/
    List<Student> getAll();

    int like(String name);
}
