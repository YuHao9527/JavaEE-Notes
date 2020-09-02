package com.yhp.web;

import com.yhp.bean.Student;
import com.yhp.service.StudentService;
import com.yhp.service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Administrator
 * mvcdemo
 * 面向对象面向君  不负代码不负卿
 */
@WebServlet(value = "/getallstudent")
public class StudentServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         //1.接受参数
        //2.调取service方法
        StudentService studentService=new StudentServiceImpl();
        List<Student> students = studentService.getall();
        //3.跳转页面
        req.setAttribute("students",students);
        req.getRequestDispatcher("show.jsp").forward(req,resp);
    }
}
