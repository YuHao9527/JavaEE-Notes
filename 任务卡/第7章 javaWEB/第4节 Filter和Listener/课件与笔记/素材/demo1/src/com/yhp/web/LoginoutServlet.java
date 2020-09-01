package com.yhp.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Administrator
 * demo1
 * 面向对象面向君  不负代码不负卿
 */

@WebServlet(value="/loginout")
public class LoginoutServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         //让session失效
        HttpSession session = req.getSession();
      //  session.removeAttribute("loginuname");
        session.invalidate();//让所有的session的相关值都清除
        resp.sendRedirect("index.jsp");
    }
}
