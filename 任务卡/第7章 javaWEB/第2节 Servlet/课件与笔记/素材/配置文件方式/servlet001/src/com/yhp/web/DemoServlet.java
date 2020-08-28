package com.yhp.web;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Administrator
 * servlet001
 * 面向对象面向君  不负代码不负卿
 */
public class DemoServlet implements Servlet {

    public DemoServlet(){
        System.out.println("demoServlet()");
    }
    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("DemoServlet初始化");
        //获得init-param的值,针对单个servlet
       String myencoding = config.getInitParameter("myencoding");
        System.out.println(" String myencoding = "+myencoding);
        //获得context-param的值,针对所有的servlet
        String code = config.getServletContext().getInitParameter("code");
        System.out.println("code="+code);
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override   //默认调取service方法实现业务处理
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("DemoServlet-->sessionid="+((HttpServletRequest)servletRequest).getSession().getId());
        System.out.println("执行业务逻辑的方法");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("销毁servlet");
    }
}
