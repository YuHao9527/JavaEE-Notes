package com.yhp.bean;

import java.util.Date;

//多方
public class Bills {
    private Integer id;

    private String title;

    private Date billtime;

    private Integer typeid;

    private Double price;

    private String explains;

    public Billtype getBilltype() {
        return billtype;
    }

    public void setBilltype(Billtype billtype) {
        this.billtype = billtype;
    }

    private Billtype billtype;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Date getBilltime() {
        return billtime;
    }

    public void setBilltime(Date billtime) {
        this.billtime = billtime;
    }

    public Integer getTypeid() {
        return typeid;
    }

    public void setTypeid(Integer typeid) {
        this.typeid = typeid;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getExplains() {
        return explains;
    }

    public void setExplains(String explains) {
        this.explains = explains == null ? null : explains.trim();
    }
}