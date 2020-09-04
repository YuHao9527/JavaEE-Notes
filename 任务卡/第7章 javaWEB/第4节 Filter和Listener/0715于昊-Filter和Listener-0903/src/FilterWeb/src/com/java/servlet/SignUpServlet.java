package com.java.servlet;

import com.java.util.DruidUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

/**
 * @ClassName SignUpServlet
 * @Description 注册
 * @Author 0715-YuHao
 * @Date 2020/9/3 15:28
 */
@WebServlet(value = "/signUp")
public class SignUpServlet extends HttpServlet {
    private Connection conn;
    private PreparedStatement state;
    private PreparedStatement state2;
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String username = req.getParameter("uname");
            String password = req.getParameter("upass");
            conn = DruidUtil.getConnection();
            state = conn.prepareStatement("select username from user where username=?");
            state.setString(1, username);
            ResultSet res = state.executeQuery();
            if (res.next()) {
                PrintWriter writer = resp.getWriter();
                writer.print("<script>alert('注册失败，用户名已存在');window.location.href='signUp.jsp';</script>");
                writer.close();
            }else {
                state2 = conn.prepareStatement("INSERT INTO user VALUES (null, ?, ?, 0)");
                state2.setString(1, username);
                state2.setString(2, password);
                state2.execute();
                req.getSession().setAttribute("uName", username);
                req.getSession().setAttribute("uPass", password);
                PrintWriter writer = resp.getWriter();
                writer.print("<script>alert('注册成功');window.location.href='login.jsp';</script>");
                writer.close();
                state2.close();
            }
        } catch (Exception throwables) {
            throwables.printStackTrace();
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
