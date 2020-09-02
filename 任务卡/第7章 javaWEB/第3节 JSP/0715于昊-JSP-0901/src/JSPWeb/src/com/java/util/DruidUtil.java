package com.java.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * @ClassName com.java.util.DruidUtil
 * @Description 数据库连接池工具类
 * @Author 0715-YuHao
 * @Date 2020/9/2 10:05
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

    /**
     * @Author 0715-YuHao
     * @Description 从数据库连接池中获取一个连接
     * @Date 2020/9/2 11:11
     * @Param []
     * @return java.sql.Connection
     */
    public static Connection getConnection() {
        try {
            return ds.getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    /**
     * @Author 0715-YuHao
     * @Description 释放资源
     * @Date 2020/9/2 11:11
     * @Param []
     * @return void
     */
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
