package com.yhp.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Administrator
 * demo1
 * 面向对象面向君  不负代码不负卿
 */
@WebServlet(value = "/login")
public class LoginServlet  extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("loginservlet");

        String uname = req.getParameter("uname");
        if("admin".equals(uname)){
            req.getSession().setAttribute("loginuname",uname);
            resp.sendRedirect("/success.jsp");//丢失request的值
        }else{
            Cookie cookie = new Cookie("username",uname);
            resp.addCookie(cookie);
            resp.sendRedirect("/index.jsp");
        }
    }
}
