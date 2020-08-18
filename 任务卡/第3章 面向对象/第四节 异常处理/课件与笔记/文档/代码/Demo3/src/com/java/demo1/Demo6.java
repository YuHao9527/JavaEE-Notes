package com.java.demo1;

public class Demo6 {
    public static void main(String[] args) {
        Person p = haha();
        System.out.println(p.age);
    }
    public static Person haha(){
        Person p = new Person();
        try{
            p.age = 18;
            return p;
        }catch(Exception e){
            return null;
        }finally {
            p.age = 28;
        }
    }
    static class Person{
        int age;
    }
}
