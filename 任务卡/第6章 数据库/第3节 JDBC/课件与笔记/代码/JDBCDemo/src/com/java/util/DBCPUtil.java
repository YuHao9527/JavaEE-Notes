package com.java.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.apache.commons.dbcp.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DBCPUtil {

    private static DataSource ds;
    static{
        try {
            Properties ppt = new Properties();
            ppt.load(DBCPUtil.class.getClassLoader().getResourceAsStream("dbcp.properties"));
            ds = BasicDataSourceFactory.createDataSource(ppt);
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
        } catch (SQLException throwables) {
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
