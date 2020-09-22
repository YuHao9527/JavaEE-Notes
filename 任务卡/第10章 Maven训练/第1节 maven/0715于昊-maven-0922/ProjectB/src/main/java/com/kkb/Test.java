package com.kkb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @ClassName Demo
 * @Description 测试ProjectA
 * @Author 0715-YuHao
 * @Date 2020/9/22 9:54
 */
public class Test {
    public static void main(String[] args) {
        Connection connection = DruidUtil.getConnection();
        PreparedStatement statement = null;
        ResultSet res = null;
        try {
            statement = connection.prepareStatement("SELECT name FROM courier");
            res = statement.executeQuery();
            while (res.next()) {
                System.out.println(res.getString("name"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
