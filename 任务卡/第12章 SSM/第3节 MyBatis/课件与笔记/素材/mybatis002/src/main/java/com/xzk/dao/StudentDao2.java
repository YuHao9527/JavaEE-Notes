package com.xzk.dao;

import com.xzk.bean.Student;
import com.xzk.util.SqlUtil;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@CacheNamespace
public interface StudentDao2 {
    //增删改查
    @InsertProvider(type = SqlUtil.class,method = "insertMethod")
    @Options(useGeneratedKeys = true,keyProperty = "studentId")//获得新增数据的id
    public int insertStu(Student student);

    @UpdateProvider(type = SqlUtil.class,method = "updateMethod")
    public int updateStu(Student student);

    @SelectProvider(type = SqlUtil.class,method = "selectall")
    @Results({
            @Result(column = "stuage",property = "age")
    })
    @Options(useCache = true,flushCache = Options.FlushCachePolicy.FALSE,timeout = 9999999)
    public List<Student> findall();

    //两表联查
    //查询所有学生以及其班级信息
    @ResultMap("com.xzk.dao.StudentDao2.rs3")
    @Select("select * from student s,grade g where s.gradeid=g.gid")
    public List<Student> getAllStudent();


    @InsertProvider(type = SqlUtil.class,method = "insertMethod")
    @Options(useGeneratedKeys = true,keyProperty = "studentId")//获得新增数据的id
    public int insertParam(@Param("studentNo") String stuno,@Param("stuName") String stuname,@Param("age") int age);

}
