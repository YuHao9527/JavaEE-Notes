package com.java.demo4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    public static void main(String[] args){
        Connection conn = null;
        Statement state = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf-8","root","123");
            state = conn.createStatement();

            conn.setAutoCommit(false);
            state.executeUpdate("update xzk_user set account=50 where username='张三'");
            if(1==2){
                throw new RuntimeException("停电了");
            }
            state.executeUpdate("update xzk_user set account=150 where username='李四'");
            conn.commit();
            conn.setAutoCommit(true);
        }catch(Exception e){
            e.printStackTrace();
            try {
                conn.rollback();
            } catch (Exception throwables) {
                throwables.printStackTrace();
            }
        }finally {
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
    }
}
