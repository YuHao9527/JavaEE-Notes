package com.yhp.util;


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Administrator
 * demo1
 * 面向对象面向君  不负代码不负卿
 */

public class Filter2 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("初始化filter2");
    }
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("过滤器开始执行2");
        HttpServletRequest request=(HttpServletRequest)servletRequest;
        HttpServletResponse response=(HttpServletResponse)servletResponse;
        request.setCharacterEncoding("utf-8");//处理所有的servlet乱码

        String loginuname = (String)request.getSession().getAttribute("loginuname");
        String requestURI = request.getRequestURI();//获得请求地址
        System.out.println("requestURI="+requestURI);
        //对某些资源放行（用户未登录的情况下可以访问的资源,或session有值的情况下可以访问）
        if(requestURI.endsWith("/")||requestURI.endsWith("message.jsp")||requestURI.endsWith("/index.jsp")||
        requestURI.endsWith("/login")||loginuname!=null){
            filterChain.doFilter(servletRequest, servletResponse);//调取下一个servlet或filter
        }else{
            response.sendRedirect("/message.jsp");
        }
        System.out.println("过滤器结束执行2");
    }

    @Override
    public void destroy() {
        System.out.println("销毁filter2");
    }
}
