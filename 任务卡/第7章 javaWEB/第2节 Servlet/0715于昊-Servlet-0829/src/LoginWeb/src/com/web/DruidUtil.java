package com.web;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

/**
 * @ClassName DruidUtil
 * @Description 数据库连接池工具类
 * @Author 0715-YuHao
 * @Date 2020/8/31 18:55
 * @Version 1.0
 */
public class DruidUtil {
    private static DataSource ds;
    static{
        try {
            Properties ppt = new Properties();
            ppt.load(DruidUtil.class.getClassLoader().getResourceAsStream("druid.properties"));
            ds = DruidDataSourceFactory.createDataSource(ppt);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 从连接池中取出一个连接给用户
     * @return
     */
    public static Connection getConnection(){
        try {
            return ds.getConnection();
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }
        return null;
    }


    public static void close(Connection conn, Statement state, ResultSet rs){
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
}
