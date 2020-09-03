package com.java.servlet;

import com.java.util.DruidUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @ClassName LoginServlet
 * @Description 登录
 * @Author 0715-YuHao
 * @Date 2020/9/3 14:34
 */
@WebServlet(value = "/login")
public class LoginServlet extends HttpServlet {
    private Connection conn;
    private PreparedStatement ppt;
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            conn = DruidUtil.getConnection();
            ppt = conn.prepareStatement("select * from user where username=?");
            String username = req.getParameter("uname");
            String password = req.getParameter("upass");
            ppt.setString(1, username);
            ResultSet res = ppt.executeQuery();
            while (res.next()) {
                if (res.getString("password").equals(password)) {
                    req.getSession().setAttribute("loginName", username);
                    req.getSession().setAttribute("points", res.getInt("points"));
                    resp.sendRedirect("/success.jsp");
                }else {
                    PrintWriter writer = resp.getWriter();
                    writer.print("<script>alert('登录失败，用户名或密码错误！');window.location.href='login.jsp';</script>");
                    writer.close();
                }
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            try {
                ppt.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
