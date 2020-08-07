package com.java.demo1;

public class Person {
    private String name;
    private int age;

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
        if(age<0 || age>180){
            RuntimeException e = new RuntimeException("年龄不合理");
            throw e;
        }else{
            this.age = age;
        }

    }
}
