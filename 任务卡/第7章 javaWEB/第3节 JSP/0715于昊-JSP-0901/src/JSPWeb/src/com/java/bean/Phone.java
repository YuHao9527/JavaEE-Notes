package com.java.bean;

import java.util.Objects;

/**
 * @ClassName Phone
 * @Description 手机类
 * @Author 0715-YuHao
 * @Date 2020/9/2 11:22
 */
public class Phone {
    private String pname;
    private float price;
    private String pimg;
    private String info;

    public Phone() {
    }

    public Phone(String pname, float price, String pimg, String info) {
        this.pname = pname;
        this.price = price;
        this.pimg = pimg;
        this.info = info;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getPimg() {
        return pimg;
    }

    public void setPimg(String pimg) {
        this.pimg = pimg;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Phone phone = (Phone) o;

        return Objects.equals(pname, phone.pname);
    }

    @Override
    public int hashCode() {
        return pname != null ? pname.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "pname='" + pname + '\'' +
                ", price=" + price +
                ", pimg='" + pimg + '\'' +
                ", info='" + info + '\'' +
                '}';
    }
}
