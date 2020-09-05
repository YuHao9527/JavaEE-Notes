package com.java.web;

import com.java.service.StudentService;
import com.java.service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @ClassName LikeServlet
 * @Description 点赞
 * @Author 0715-YuHao
 * @Date 2020/9/5 9:40
 */
@WebServlet(value = "/like")
public class LikeServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        StudentService service = new StudentServiceImpl();
        int like = service.like(name);
        PrintWriter writer = resp.getWriter();
        writer.print(like);
        writer.close();
    }
}
