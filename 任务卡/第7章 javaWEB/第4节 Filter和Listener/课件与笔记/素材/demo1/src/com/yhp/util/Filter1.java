package com.yhp.util;


import javax.servlet.*;
import java.io.IOException;

/**
 * Administrator
 * demo1
 * 面向对象面向君  不负代码不负卿
 */

public class Filter1 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("初始化filter1");
    }
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("过滤器开始执行1");
        filterChain.doFilter(servletRequest, servletResponse);//调取下一个servlet或filter
        System.out.println("过滤器结束执行1");
    }

    @Override
    public void destroy() {
        System.out.println("销毁filter1");
    }
}
