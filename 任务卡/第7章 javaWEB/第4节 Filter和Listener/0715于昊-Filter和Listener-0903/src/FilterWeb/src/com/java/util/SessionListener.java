package com.java.util;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.sql.DataSource;

/**
 * @ClassName SessionListener
 * @Description 监听Session
 * @Author 0715-YuHao
 * @Date 2020/9/3 9:36
 */
public class SessionListener implements HttpSessionListener {
    private static DataSource ds;
    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {

    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {

    }
}
