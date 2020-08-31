package com.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;


/**
 * @ClassName SignUpServlet
 * @Description 注册
 * @Author 0715-YuHao
 * @Date 2020/8/31 21:13
 * @Version 1.0
 */
public class SignUpServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Get请求
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Connection conn = DruidUtil.getConnection();
            PreparedStatement state = conn.prepareStatement("insert into user values(null, ?, ?)");
            req.setCharacterEncoding("utf-8");
            resp.setContentType("text/html;charset=utf-8");
            String username = req.getParameter("uname");
            String password = req.getParameter("upass");
            state.setString(1, username);
            state.setString(2, password);
            PrintWriter writer = resp.getWriter();
            writer.print("<script>alert('注册成功');window.location.href='login.html'</script>");
            writer.close();
            state.close();
            conn.close();
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void destroy() {
        System.out.println("SignUpServlet已销毁");
    }

    @Override
    public void init() throws ServletException {
        System.out.println("SignUp初始化成功");
    }
}
