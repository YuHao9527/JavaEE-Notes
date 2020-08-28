package com.yhp;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Administrator
 * servlet002
 * 面向对象面向君  不负代码不负卿
 */

@WebServlet(urlPatterns = {"/test"},
        initParams ={
            @WebInitParam(name = "code",value = "utf-8")
        },loadOnStartup = 1)
public class TestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("get请求被执行");
        resp.sendRedirect("success.html");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("初始化参数code="+config.getInitParameter("code"));
    }
}
