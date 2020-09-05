package com.java.web;

import com.java.bean.Student;
import com.java.service.StudentService;
import com.java.service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @ClassName StudentServlet
 * @Description StudentServlet
 * @Author 0715-YuHao
 * @Date 2020/9/4 23:39
 * @Version 1.0
 */
@WebServlet(value = "/getAll")
public class StudentServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StudentService service = new StudentServiceImpl();
        List<Student> students = service.getAll();
        req.setAttribute("stdents", students);
        req.getSession().setAttribute("flag", "accessed");
        req.getRequestDispatcher("show.jsp").forward(req, resp);
    }
}
