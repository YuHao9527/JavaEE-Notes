package com.xzk.dao.impl;

import com.xzk.bean.Student;
import com.xzk.dao.StudentDao;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Administrator
 * springJdbc
 * 面向对象面向君  不负代码不负卿
 */
public class StudentDaoImpl extends JdbcDaoSupport implements StudentDao {
    @Transactional
    public int insert(Student student) {
        String sql="insert into student(studentid,studentno,stuname) values(?,?,?)";
        int update = getJdbcTemplate().update(sql, student.getStudentId(), student.getStudentNo(), student.getStuName());
        //System.out.println(7/0);
        return update;
    }

    public Student findbyid(int id) {
        String sql="select * from student where studentid=?";
        Student stu = getJdbcTemplate().queryForObject(sql, new Object[]{id}, new RowMapper<Student>() {
            public Student mapRow(ResultSet resultSet, int i) throws SQLException {
                //和原来jdbc获取结果集之后的操作时一样的
                Student student = new Student();
                student.setStudentId(resultSet.getInt("studentid"));
                student.setStuName(resultSet.getString("stuname"));
                return student;
            }
        });

        return stu;
    }

    public List<Student> findall() {
        String sql="select * from student";
        List<Student> students = getJdbcTemplate().query(sql, new RowMapper<Student>() {
            public Student mapRow(ResultSet resultSet, int i) throws SQLException {
                //和原来jdbc获取结果集之后的操作时一样的
                Student student = new Student();
                student.setStudentId(resultSet.getInt("studentid"));
                student.setStuName(resultSet.getString("stuname"));
                return student;
            }
        });
        return students;
    }
}
