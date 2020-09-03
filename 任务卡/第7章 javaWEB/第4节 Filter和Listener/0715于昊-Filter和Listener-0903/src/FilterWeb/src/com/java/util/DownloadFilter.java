package com.java.util;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @ClassName DownloadFilter
 * @Description TODO
 * @Author 0715-YuHao
 * @Date 2020/9/3 22:53
 * @Version 1.0
 */
public class DownloadFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        int points = (int) request.getSession().getAttribute("points");
        if (points > 100) {
            filterChain.doFilter(servletRequest, servletResponse);
        }else {
            PrintWriter writer = response.getWriter();
            writer.print("<script>alert('不好意思，你的积分不足，请充值！');window.location.href='success.jsp'</script>");
            writer.close();
        }
    }

    @Override
    public void destroy() {

    }
}
