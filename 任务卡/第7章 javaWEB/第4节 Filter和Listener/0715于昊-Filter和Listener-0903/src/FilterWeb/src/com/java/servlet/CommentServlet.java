package com.java.servlet;

import com.java.util.DruidUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @ClassName DownloadServlet
 * @Description 下载
 * @Author 0715-YuHao
 * @Date 2020/9/3 22:08
 * @Version 1.0
 */
@WebServlet(value = "/comment")
public class CommentServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Connection conn = DruidUtil.getConnection();
            PreparedStatement state = conn.prepareStatement("INSERT INTO comment VALUES (null, ?, ?)");
            String info = (String) req.getAttribute("comment");
            String userName = (String) req.getSession().getAttribute("loginName");
            state.setString(1, info);
            state.setString(2, userName);
            state.execute();
            state.close();
            conn.close();
            resp.sendRedirect("/download");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
