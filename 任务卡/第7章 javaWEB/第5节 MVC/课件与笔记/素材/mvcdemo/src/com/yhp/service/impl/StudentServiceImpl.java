package com.yhp.service.impl;

import com.yhp.bean.Student;
import com.yhp.dao.StudentDao;
import com.yhp.dao.impl.StudentDaoImpl;
import com.yhp.service.StudentService;

import java.util.List;

/**
 * Administrator
 * mvcdemo
 * 面向对象面向君  不负代码不负卿
 */

public class StudentServiceImpl implements StudentService {

    private StudentDao dao=new StudentDaoImpl();

    @Override
    public List<Student> getall() {
        return dao.getall();
    }
}
