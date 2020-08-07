package com.kaikeba.task3;

/**
 * @ClassName Clothes
 * @Description 衣服类
 * @Author 0715-YuHao
 * @Date 2020/7/23 10:28
 */
class Clothes {
    private String brand;
    private String color;
    private String size;
    // 静态属性count，用于记录衣服对象创建的序号值
    static int count;

    Clothes() {
        System.out.println("衣服序号：" + ++count);
    }

    Clothes(String brand, String color, String size) {
        this.brand = brand;
        this.color = color;
        this.size = size;
        System.out.println("衣服序号：" + ++count);
    }

    String getBrand() {
        return brand;
    }

    void setBrand(String brand) {
        this.brand = brand;
    }

    String getColor() {
        return color;
    }

    void setColor(String color) {
        this.color = color;
    }

    String getSize() {
        return size;
    }

    void setSize(String size) {
        this.size = size;
    }
}
