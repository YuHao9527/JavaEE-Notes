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
@WebServlet(value = "/testcookie")
public class CookieServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("CookieServlet");
        //1.创建cookie
        Cookie cookie = new Cookie("c1","cookieTest");
        //2.响应给客户端
        response.addCookie(cookie);
        //3.跳转页面
        response.sendRedirect("show.jsp");
    }
}
