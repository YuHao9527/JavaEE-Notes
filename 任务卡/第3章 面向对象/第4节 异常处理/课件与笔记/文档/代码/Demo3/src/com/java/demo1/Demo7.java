package com.java.demo1;

public class Demo7 {
    public static void main(String[] args) {
        int a = haha();
        System.out.println(a);
    }
    public static int haha(){
        int a = 10;
        try{
            return a;
        }catch(Exception e){

        }finally {
            a = 20;
        }
        return 0;
    }
    static class Person{
        int age;
    }
}
