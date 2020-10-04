package com.xzk.dao;

import com.xzk.bean.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

public interface StudentDao {
    //增删改查
    @Insert("insert into student(studentno,stuname,stuage) values(#{studentNo},#{stuName},#{age})")
    @Options(useGeneratedKeys = true,keyProperty = "studentId")//获得新增数据的id
    public int insertStu(Student student);

    @Update("update student set studentno=#{studentNo},stuname=#{stuName} where studentid=#{studentId}")
    public int updateStu(Student student);

    @Select("select * from student")
    @Results({
            @Result(column = "stuage",property = "age")
    })
    public List<Student> findall();

    @Select("select count(*) from student")
    public int totalCount();

    @Delete("delete from student where studentid=#{sid}")
    public int deleteStu(int sid);
    //计算id的最大值，最小值，平均值
    @Select("select max(studentid) max,min(studentid) min,avg(studentid) avg from student")
    public Map total2();

}
