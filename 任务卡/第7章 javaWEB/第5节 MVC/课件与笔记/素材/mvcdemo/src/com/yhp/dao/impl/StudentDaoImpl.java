package com.yhp.dao.impl;

import com.yhp.bean.Student;
import com.yhp.dao.StudentDao;
import com.yhp.util.DruidUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Administrator
 * mvcdemo
 * 面向对象面向君  不负代码不负卿
 */

public class StudentDaoImpl extends DruidUtil implements StudentDao {
    @Override
    public List<Student> getall() {
        List list=new ArrayList();
        Connection connection =null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet =null;
        try {
             connection = getConnection();
            String sql="select * from student";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Student student = new Student();
                student.setStudentId(resultSet.getInt("studentid"));
                student.setStudentNo(resultSet.getString("studentno"));
                student.setStuName(resultSet.getString("stuname"));
                student.setStuAge(resultSet.getInt("stuage"));
                list.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(connection,preparedStatement,resultSet);
        }

        return list;
    }
}
