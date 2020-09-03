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
import java.sql.SQLException;

/**
 * @ClassName ChargeServlet
 * @Description 充值
 * @Author 0715-YuHao
 * @Date 2020/9/3 22:08
 * @Version 1.0
 */
@WebServlet(value = "/charge")
public class ChargeServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Connection conn = DruidUtil.getConnection();
            PreparedStatement state = conn.prepareStatement("UPDATE user SET points=? where username=?");
            String point = req.getParameter("point");
            int points = (int) req.getSession().getAttribute("points");
            String username = (String) req.getSession().getAttribute("loginName");
            points += Integer.parseInt(point);
            state.setString(1, String.valueOf(points));
            state.setString(2, username);
            state.executeUpdate();
            req.getSession().setAttribute("points", points);
            PrintWriter writer = resp.getWriter();
            writer.print("<script>alert('充值成功！');window.location.href='success.jsp';</script>");
            writer.close();
            state.close();
            conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
