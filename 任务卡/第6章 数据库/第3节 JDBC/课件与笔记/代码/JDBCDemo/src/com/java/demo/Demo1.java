package com.java.demo;

import java.sql.*;

public class Demo1 {
    public static void createTable() throws ClassNotFoundException, SQLException {
        //1.    加载数据库驱动 (可以省略的.  在JavaEE的web项目中,jar包不可以省略.)
        //      mysql6以下驱动:com.mysql.jdbc.Driver
        //      mysql6和6以上驱动:com.mysql.cj.jdbc.Driver
        Class.forName("com.mysql.jdbc.Driver");
        //2.    通过驱动管理器, 获取JDBC的连接对象
        //      连接地址格式:
        //           主协议:子协议://ip地址:端口号/数据库名称
        //           mysql:     jdbc:mysql://localhost:3306/test
        //           oracle:    jdbc:oracle:thin:@ip地址:1521/ORCL
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "123");
        //3.    通过连接对象,创建SQL执行对象 (SQL执行环境)
        Statement state = conn.createStatement();
        //4.    通过SQL执行对象 执行SQL
        state.execute("create table person(id int,nickname varchar(32))");
        //5.    释放连接
        state.close();
        conn.close();
    }

    public static void insertData() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf-8", "root", "123");
        Statement state = conn.createStatement();
        state.execute("insert into person values(1,'张三')");
        state.close();
        conn.close();
    }

    public static void insertPerson() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf-8", "root", "123");
        Statement state = conn.createStatement();
        int flag = state.executeUpdate("insert into person values(1,'张三'),(2,'李四'),(3,'王二麻子')");
        state.close();
        conn.close();
        System.out.println("返回:"+flag);
    }

    public static void deletePerson() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf-8", "root", "123");
        Statement state = conn.createStatement();
        int flag = state.executeUpdate("delete from person where id=1");
        state.close();
        conn.close();
        System.out.println("返回:"+flag);
    }

    public static void updatePerson() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf-8", "root", "123");
        Statement state = conn.createStatement();
        int flag = state.executeUpdate("update person set nickname='haha' where id=2");
        state.close();
        conn.close();
        System.out.println("返回:"+flag);
    }

    public static void selectPerson() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf-8", "root", "123");
        Statement state = conn.createStatement();
        ResultSet rs = state.executeQuery("select * from person");
        while(rs.next()){
            int id = rs.getInt("id");
            String nickname = rs.getString("nickname");
            System.out.println("id="+id+"\tnickname="+nickname);
        }
        rs.close();
        state.close();
        conn.close();
    }
}
