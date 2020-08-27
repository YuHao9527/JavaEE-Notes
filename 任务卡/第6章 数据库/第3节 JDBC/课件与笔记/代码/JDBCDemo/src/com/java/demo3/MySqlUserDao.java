package com.java.demo3;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySqlUserDao implements BaseUserDao{
    static{
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    @Override
    public boolean insert(String username, String password) {
        Connection conn = null;
        Statement state = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf-8", "root", "123");
            state = conn.createStatement();
            //insert into xzk_user values('username','password')    :   字符串的定义格式  字符串的表现格式
            int row = state.executeUpdate("insert into xzk_user values('" + username + "','" + password + "')");
            return row>0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            try {
                state.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public boolean findByPassword(String username, String password) {
        Connection conn = null;
        PreparedStatement state = null;
        ResultSet rs = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf-8", "root", "123");
            //参数: 预编译的SQL语句, 参数部分使用?替代.
            state = conn.prepareStatement("select * from xzk_user where username=? and password=?");
            //向预编译的执行环境中, 加入参数的内容
            state.setString(1,username);
            state.setString(2,password);
            //执行
            rs = state.executeQuery();
            return rs.next();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            try {
                rs.close();
            } catch (Exception throwables) {
                throwables.printStackTrace();
            }
            try {
                state.close();
            } catch (Exception throwables) {
                throwables.printStackTrace();
            }
            try {
                conn.close();
            } catch (Exception throwables) {
                throwables.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public boolean findByPassword2(String username, String password) {
        Connection conn = null;
        Statement state = null;
        ResultSet rs = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf-8", "root", "123");
            state = conn.createStatement();
            //执行
            rs = state.executeQuery("select * from xzk_user where username='"+username+"' and password='"+password+"'");
            return rs.next();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            try {
                rs.close();
            } catch (Exception throwables) {
                throwables.printStackTrace();
            }
            try {
                state.close();
            } catch (Exception throwables) {
                throwables.printStackTrace();
            }
            try {
                conn.close();
            } catch (Exception throwables) {
                throwables.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public List<User> findAll() {
        List<User> data = new ArrayList<>();
        Connection conn = null;
        Statement state = null;
        ResultSet rs = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf-8", "root", "123");
            state = conn.createStatement();
            rs = state.executeQuery("select * from xzk_user");
            while(rs.next()){
                String username = rs.getString("username");
                String password = rs.getString("password");
                data.add(new User(username,password));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            try {
                rs.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                state.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return data;
    }
}
