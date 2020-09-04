package com.java.util;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.http.HttpRequest;

/**
 * @ClassName ChargeFilter
 * @Description 充值过滤
 * @Author 0715-YuHao
 * @Date 2020/9/4 9:24
 */
public class ChargeFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        String point = req.getParameter("point");
        try {
            int points = Integer.parseInt(point);
            if (points <= 10000 || points > 0) {
                filterChain.doFilter(servletRequest, servletResponse);
            }else {
                PrintWriter writer = resp.getWriter();
                writer.println("<script>alert('充值失败，请检查你的输入是否合法');window.location.href='success.jsp';</script>");
                writer.close();
            }
        }catch (NumberFormatException e) {
            PrintWriter writer = resp.getWriter();
            writer.println("<script>alert('充值失败，请检查你的输入是否合法');window.location.href='success.jsp';</script>");
            writer.close();
        }
    }

    @Override
    public void destroy() {

    }
}
