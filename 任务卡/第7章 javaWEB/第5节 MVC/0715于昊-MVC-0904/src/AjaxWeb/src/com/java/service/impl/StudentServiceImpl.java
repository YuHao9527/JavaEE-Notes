package com.java.service.impl;

import com.java.bean.Student;
import com.java.dao.StudentDao;
import com.java.dao.impl.StudentDaoImpl;
import com.java.service.StudentService;

import java.util.List;

/**
 * @ClassName StudentServiceImpl
 * @Description StudentService实现类
 * @Author 0715-YuHao
 * @Date 2020/9/4 23:37
 * @Version 1.0
 */
public class StudentServiceImpl implements StudentService {

    private StudentDao dao = new StudentDaoImpl();

    @Override
    public List<Student> getAll() {
        return dao.getAll();
    }

    @Override
    public int like(String name) {
        return dao.like(name);
    }
}
