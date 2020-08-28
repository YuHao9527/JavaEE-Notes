package com.yhp.web;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Administrator
 * servlet001
 * 面向对象面向君  不负代码不负卿
 */

public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //处理get请求
       // req.getRequestDispatcher("loginError.html").forward(req,resp);
        //由后台给前台返回一段js代码
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        writer.print("<script>alert('请通过表单进行登录');location.href='/login.html'</script>");
    }

    String myencoding =null;
    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("初始化");
        myencoding = config.getInitParameter("myencoding");
        System.out.println(" String myencoding = "+myencoding);
        //获得context-param的值,针对所有的servlet
        String code = config.getServletContext().getInitParameter("code");
        System.out.println("code="+code);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("LoginServlet-->sessionid="+req.getSession().getId());
        System.out.println("session的非活动时间的默认值:"+req.getSession().getMaxInactiveInterval());
        //处理post请求
        req.setCharacterEncoding(myencoding);//一定要在接受参数的前面
        //1.接受参数
        String uname = req.getParameter("uname");
        String upass = req.getParameter("upass");
        System.out.println("uname="+uname+",upass="+upass);
        String[] loves = req.getParameterValues("love");
        for (String love : loves) {
            System.out.println("love="+love);
        }
        //2.跳转页面测试
        if("admin".equals(uname)){
            //req.getRequestDispatcher("/success.html").forward(req,resp);
            resp.sendRedirect("/success.html");  //重定向
        }else{
            req.getRequestDispatcher("/error.html").forward(req,resp);//转发
        }


    }

    @Override
    public void destroy() {
        System.out.println("销毁方法");
    }


}
