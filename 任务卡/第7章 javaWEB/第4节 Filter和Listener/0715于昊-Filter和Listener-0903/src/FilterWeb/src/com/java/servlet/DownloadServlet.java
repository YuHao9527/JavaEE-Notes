package com.java.servlet;

import com.java.bean.Comment;
import com.java.util.DruidUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName DownloadServlet
 * @Description 下载
 * @Author 0715-YuHao
 * @Date 2020/9/3 22:53
 * @Version 1.0
 */
@WebServlet(value = "/download")
public class DownloadServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            List<Comment> commentList = new ArrayList<>();
            Connection conn = DruidUtil.getConnection();
            PreparedStatement state = conn.prepareStatement("SELECT info,username FROM comment");
            ResultSet res = state.executeQuery();
            while (res.next()) {
                commentList.add(new Comment(res.getString("info"), res.getString("username")));
            }
            req.getSession().setAttribute("comments", commentList);
            resp.sendRedirect("download.jsp");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
