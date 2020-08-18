package com.java.demo1;

public class Demo8 {
    public static void main(String[] args) {

        haha();
    }
    public static void haha(){
        try{
            int a = 10;
            int b = 0;
            System.out.println(a/b);
        }catch(Exception e){
            //退出JVM
            System.out.println("出现了异常");
            System.exit(0);
        }finally {
            System.out.println("锄禾日当午,汗滴禾下土");
        }
    }
}
