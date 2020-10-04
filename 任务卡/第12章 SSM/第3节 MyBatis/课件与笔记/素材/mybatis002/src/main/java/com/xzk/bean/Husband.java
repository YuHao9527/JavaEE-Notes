package com.xzk.bean;

/**
 * Administrator
 * mybatis
 * 面向对象面向君  不负代码不负卿
 */
public class Husband {
    private int husId;
    private String husName;
    private Wife wife;

    public int getHusId() {
        return husId;
    }

    public void setHusId(int husId) {
        this.husId = husId;
    }

    public String getHusName() {
        return husName;
    }

    public void setHusName(String husName) {
        this.husName = husName;
    }

    public Wife getWife() {
        return wife;
    }

    public void setWife(Wife wife) {
        this.wife = wife;
    }
}
