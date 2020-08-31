package com.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName FindBackServlet
 * @Description 忘记密码
 * @Author 0715-YuHao
 * @Date 2020/8/31 16:59
 * @Version 1.0
 */
public class FindBackServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("../findBack.html");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // POST请求
    }

    @Override
    public void destroy() {
        System.out.println("FindBackServlet已销毁");
    }

    @Override
    public void init() throws ServletException {
        System.out.println("FindBackServlet初始化成功");
    }
}
