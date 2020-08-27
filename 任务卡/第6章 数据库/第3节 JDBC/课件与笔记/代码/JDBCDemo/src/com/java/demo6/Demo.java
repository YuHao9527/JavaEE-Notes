package com.java.demo6;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Demo {
//    DBCP
    public static void main(String[] args) throws Exception {
        //1.    引入jar文件
        //2.    将配置文件 properties文件 放到src文件夹下
        //3.    将properties文件 转换为Properties对象
        Properties ppt = new Properties();
        InputStream is = Demo.class.getClassLoader().getResourceAsStream("dbcp.properties");
        ppt.load(is);
        //4.    通过连接池的工厂类, 创建连接池
        DataSource dataSource = BasicDataSourceFactory.createDataSource(ppt);
        //5.    从池中获取一个连接
        Connection conn = dataSource.getConnection();
        Statement state = conn.createStatement();
        state.execute("insert into person values('zhangsan','lisi')");
        state.close();
        conn.close();
    }
}
