package com.xzk.bean;

/**
 * Administrator
 * springDemo1
 * 面向对象面向君  不负代码不负卿
 */
public class Users {

    public Users(){
        System.out.println("Users()");
    }

    //静态方法
    public static Student getStudent() {
        System.out.println("static -student");
        return new Student();
    }
    //非静态方法
    public  Student getStudent2() {
        System.out.println("static2 -student2");
        return new Student();
    }

    private String name;
    private int age;

    public Users(int age) {
        this.age = age;
    }

    public Users(String name) {
        this.name = name;
    }

    public Users(String name, int age) {
        System.out.println("name="+name+",age="+age);
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void userInit(){
        System.out.println("users()初始化方法");
    }
    public void usersDes(){
        System.out.println("users()销毁的方法");
    }
}
