package com.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @ClassName LoginServlet
 * @Description 登录Servlet
 * @Author 0715-YuHao
 * @Date 2020/8/31 16:37
 * @Version 1.0
 */
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Connection conn = DruidUtil.getConnection();
            PreparedStatement state = conn.prepareStatement("select password from user where username=?");
            req.setCharacterEncoding("utf-8");
            resp.setContentType("text/html;charset=utf-8");
            String username = req.getParameter("uname");
            String password = req.getParameter("upass");
            state.setString(1, username);
            ResultSet res = state.executeQuery();
            while (res.next()) {
                String pw = res.getString("password");
                if (pw.equals(password)) {
                    req.getRequestDispatcher("success.html").forward(req, resp);
                }else {
                    PrintWriter writer = resp.getWriter();
                    writer.print("<script>alert('登录失败，用户名或密码错误！');window.location.href='login.html'</script>");
                    writer.close();
                }
            }
            res.close();
            state.close();
            conn.close();
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void destroy() {
        System.out.println("LoginServlet已销毁");
    }

    @Override
    public void init() throws ServletException {
        System.out.println("Login初始化成功");
    }
}
