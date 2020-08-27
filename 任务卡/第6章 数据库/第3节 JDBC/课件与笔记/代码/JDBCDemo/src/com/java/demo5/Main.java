package com.java.demo5;

import java.sql.*;

public class Main {
    //statment
    public static void insert1_1() throws SQLException {

        for (int i=0;i<1000;i++) {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf-8", "root", "123");
            Statement state = conn.createStatement();
            state.executeUpdate("insert into person values('admin','123"+i+"')");
            state.close();
            conn.close();
        }

    }
    //statement 批处理
    public static void insert1_2() throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf-8", "root", "123");
        Statement state = conn.createStatement();
        for (int i=0;i<1000;i++) {
            //向批处理中 加入一条SQL
            state.addBatch("insert into person values('admin','123"+i+"')");
        }
        //执行批处理
        state.executeBatch();
        //清空批处理指令
        state.clearBatch();
        state.close();
        conn.close();
    }

    //PreparedStatement
    public static void insert2_1() throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf-8", "root", "123");
        PreparedStatement state = conn.prepareStatement("insert into person values(?,?)");
        for (int i=0;i<10000;i++) {
            state.setString(1,"admin");
            state.setString(2,"123"+i);
            state.executeUpdate();
        }
        state.close();
        conn.close();
    }
    //PreparedStatement批处理
    public static void insert2_2() throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf-8", "root", "123");
        PreparedStatement state = conn.prepareStatement("insert into person values(?,?)");
        for (int i=0;i<10000;i++) {
            state.setString(1,"admin");
            state.setString(2,"123"+i);
            state.addBatch();
        }
        //执行批处理
        state.executeBatch();
        //清空批处理指令
        state.clearBatch();
        state.close();
        conn.close();
    }

}
