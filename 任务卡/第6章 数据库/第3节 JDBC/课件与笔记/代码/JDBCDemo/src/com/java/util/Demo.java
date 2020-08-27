package com.java.util;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo {
    public static void main(String[] args) {
        try {
            Connection conn = DruidUtil.getConnection();
            Statement state = conn.createStatement();
            state.execute("insert into person values('jinpingguo','123')");
            state.close();
            conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
