package com.xzk;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Administrator
 * springJdbc
 * 面向对象面向君  不负代码不负卿
 */
public class Demo1 {
    public static void main(String[] args) throws  Exception {
        //1.创建数据库连接池对象
        ComboPooledDataSource dataSource=new ComboPooledDataSource();
        dataSource.setDriverClass("com.mysql.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/hunan?useUnicode=true&characterEncoding=utf-8");
        dataSource.setUser("root");
        dataSource.setPassword("123456");
        //2.创建工具类
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        //3.调取方法 增删改用update ，查询用query方法
        int update = jdbcTemplate.update("insert into student(studentid,studentno,stuname) values(2,'stu001','王萌')");
        System.out.println("执行成功，i="+update);
    }
}
