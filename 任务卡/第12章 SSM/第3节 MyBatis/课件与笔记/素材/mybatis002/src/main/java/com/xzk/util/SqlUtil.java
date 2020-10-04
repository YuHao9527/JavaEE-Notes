package com.xzk.util;

/**
 * Administrator
 * mybatis002
 * 面向对象面向君  不负代码不负卿
 */
//用来定义sql语句
public class SqlUtil {

    //返回值一定要是字符串
    public String insertMethod(){
        return "insert into student(studentno,stuname,stuage) values(#{studentNo},#{stuName},#{age})";
    }

    public String updateMethod(){
        return "update student set studentno=#{studentNo},stuname=#{stuName} where studentid=#{studentId}";
    }
    public String selectall(){
        return "select * from student";
    }


}
