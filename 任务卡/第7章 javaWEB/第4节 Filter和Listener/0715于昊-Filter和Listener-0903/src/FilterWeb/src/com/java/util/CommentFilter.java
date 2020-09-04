package com.java.util;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName CommentFilter
 * @Description 评论过滤器
 * @Author 0715-YuHao
 * @Date 2020/9/4 9:28
 */
public class CommentFilter implements Filter {
    List<String> banWord;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        banWord = new ArrayList<>();
        banWord.add("fuck");
        banWord.add("sb");
        banWord.add("666");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        String info = req.getParameter("comment");
        for (String word : banWord) {
            if (info.contains(word)) {
                info = info.replace(word, word.replaceAll(".","*"));
            }
        }
        req.setAttribute("comment", info);
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
