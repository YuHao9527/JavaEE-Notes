package com.yhp.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Administrator
 * demoAjax
 * 面向对象面向君  不负代码不负卿
 */
@WebServlet(value = "/testuname")
public class TestServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       //1.接受参数
        String uname = req.getParameter("uname");
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        //2.验证，注意:ajax请求处理完毕后，返回数据时使用PrintWriter输出流，且ajax默认返回原页面
        if("admin".equals(uname)){
            //用户名已存在
            writer.print("用户名已存在");
        }else{
            //用户名可用
            writer.print("用户名可用");
        }

    }
}
