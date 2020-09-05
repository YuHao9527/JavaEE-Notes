package dao.impl;

import bean.Grade;
import bean.Student;
import dao.GradeDao;
import util.DruidUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GradeDaoImpl extends DruidUtil implements GradeDao {
    @Override
    public List<Student> findAll() {
        ArrayList<Student> students = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement("select * from student s,grade g where s.gid=g.gradeid ");
            resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                //1.各自存各自的数据
                Grade grade = new Grade();
                grade.setGradeId(resultSet.getInt("gradeid"));
                grade.setGname(resultSet.getString("gname"));

                Student student = new Student();
                student.setStuName(resultSet.getString("stuname"));
                student.setStuAge(resultSet.getInt("stuage"));
                //2.关联信息(将年级放在学生中，再将学生放在集合中)
                student.setGrade(grade);
                students.add(student);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            close(connection,preparedStatement,resultSet);
        }

        return students;
    }

    @Override
    public Grade findById(int gid) {
        Grade grade = new Grade();
        ArrayList<Student> students = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement("select * from student s,grade g where s.gid=g.gradeid and g.gradeid=?");
            preparedStatement.setInt(1,gid);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                //1.将各自的数据信息进行存储
                grade.setGradeId(resultSet.getInt("gradeid"));
                grade.setGname(resultSet.getString("gname"));
                Student student = new Student();
                student.setStuName(resultSet.getString("stuname"));
                student.setStuAge(resultSet.getInt("stuage"));
                //2.将学生信息和年级中的属性进行关联
                //将学生放到一个集合中
                students.add(student);
            }
            //3.建立两者关系
            grade.setStudentList(students);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            close(connection,preparedStatement,resultSet);
        }
        return grade;
    }
}
