package com.java.dao.impl;

import com.java.bean.Student;
import com.java.dao.StudentDao;
import com.java.util.DruidUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName StudentDaoImpl
 * @Description StudentDao实现类
 * @Author 0715-YuHao
 * @Date 2020/9/4 23:24
 * @Version 1.0
 */
public class StudentDaoImpl extends DruidUtil implements StudentDao {
    @Override
    public List<Student> getAll() {
        List<Student> studentList = new ArrayList<>();
        Connection conn = null;
        PreparedStatement state = null;
        ResultSet res = null;
        try {
            conn = getConnection();
            state = conn.prepareStatement("SELECT * from student");
            res = state.executeQuery();
            while (res.next()) {
                studentList.add(new Student(
                   res.getString("name"),
                   res.getString("info"),
                   res.getInt("fansNum")
                ));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            close(conn, state, res);
        }

        return studentList;
    }
}
