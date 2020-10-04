package com.yhp.bean;

/**
 * Administrator
 * mybatis
 * 面向对象面向君  不负代码不负卿
 */
public class Wife {
    private int wifeId;
    private String wifeName;
    private Husband husband;

    public int getWifeId() {
        return wifeId;
    }

    public void setWifeId(int wifeId) {
        this.wifeId = wifeId;
    }

    public String getWifeName() {
        return wifeName;
    }

    public void setWifeName(String wifeName) {
        this.wifeName = wifeName;
    }

    public Husband getHusband() {
        return husband;
    }

    public void setHusband(Husband husband) {
        this.husband = husband;
    }
}
