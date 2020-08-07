package com.java.demo1;

public class Demo5 {
    public static void main(String[] args) {
        haha();
    }
    public static void haha(){
        try{
            System.out.println("1");
            System.out.println("2");
            System.out.println("3");
            System.out.println("4");
            return;
        }catch(Exception e){
        }finally {
            System.out.println("锄禾日当午,汗滴禾下土");
        }
    }
}
