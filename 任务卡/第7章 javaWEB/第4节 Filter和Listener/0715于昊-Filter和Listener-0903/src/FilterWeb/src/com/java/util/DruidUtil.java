package com.java.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * @ClassName DruidUtil
 * @Description Druid数据库连接池
 * @Author 0715-YuHao
 * @Date 2020/9/3 14:03
 */
public class DruidUtil {
    private static DataSource ds;
    //创建数据库连接池
    static {
        try {
            Properties ppt = new Properties();
            ppt.load(DruidUtil.class.getClassLoader().getResourceAsStream("druid.properties"));
            ds = DruidDataSourceFactory.createDataSource(ppt);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public static Connection getConnection() {
        try {
            return ds.getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public static void close(Connection conn, Statement state, ResultSet res) {
        try {
            conn.close();
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }
        try {
            state.close();
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }
        try {
            res.close();
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }
    }
}
