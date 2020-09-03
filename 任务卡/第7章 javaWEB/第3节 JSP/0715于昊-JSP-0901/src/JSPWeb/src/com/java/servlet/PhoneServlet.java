package com.java.servlet;

import com.java.bean.Phone;
import com.java.util.DruidUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName PhoneServlet
 * @Description Servlet
 * @Author 0715-YuHao
 * @Date 2020/9/2 11:21
 */
@WebServlet(value = "/phoneList")
public class PhoneServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Phone> phoneList = new ArrayList<>();
        //1. 从数据库连接池中获取一个连接
        Connection conn = DruidUtil.getConnection();
        //2. 创建SQL执行对象
        try {
            Statement state = conn.createStatement();
            ResultSet res = state.executeQuery("select * from phone");
            while (res.next()) {
                phoneList.add(new Phone(
                        res.getString("pname"),
                        res.getFloat("price"),
                        res.getString("pimg"),
                        res.getString("info")
                ));
            }
            res.close();
            state.close();
            conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        //将数据存储到request作用域转发给phoneList.jsp进行显示
        req.setAttribute("phoneList", phoneList);
        req.getRequestDispatcher("/phoneList.jsp").forward(req, resp);
    }
}
