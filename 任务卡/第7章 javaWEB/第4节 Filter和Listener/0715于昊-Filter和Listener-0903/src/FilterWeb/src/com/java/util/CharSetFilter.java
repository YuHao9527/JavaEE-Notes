package com.java.util;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.PageContext;
import java.io.IOException;

/**
 * @ClassName FilterDemo
 * @Description 过滤器
 * @Author 0715-YuHao
 * @Date 2020/9/3 9:07
 */
public class CharSetFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Filter初始化成功");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String loginName = (String) request.getSession().getAttribute("loginName");
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String uri = request.getRequestURI();
        if (uri.endsWith("/") || uri.endsWith("login.jsp") || uri.endsWith("message.jsp") ||
                uri.endsWith("signUp.jsp") || loginName != null) {
            filterChain.doFilter(servletRequest, servletResponse);
        }else {
            response.sendRedirect("message.jsp");
            return;
        }

    }

    @Override
    public void destroy() {
        System.out.println("Filter已销毁");
    }
}
