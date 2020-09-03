package com.java.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @ClassName LoginOutServlet
 * @Description 退出Servlet
 * @Author 0715-YuHao
 * @Date 2020/9/3 20:05
 * @Version 1.0
 */
@WebServlet(value = "/loginOut")
public class LoginOutServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        session.removeAttribute("loginName");
        session.removeAttribute("points");
        resp.sendRedirect("/login.jsp");
    }
}
