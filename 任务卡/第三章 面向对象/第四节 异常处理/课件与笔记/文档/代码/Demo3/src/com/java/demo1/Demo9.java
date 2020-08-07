package com.java.demo1;

import java.io.IOException;

public class Demo9 {
    public static void main(String[] args) {
    }

    /**
     * 异常是否抛出去, 应该站在哪个角度思考?
     *
     *  如果是因为传参导致异常 , 应该通过throws将异常抛出去.
     *
     * @param text
     * @throws IOException : 因为传递的指令不对, 会导致此问题发生
     */
    public static void shutdown(String text) throws IOException {
        Runtime.getRuntime().exec(text);
    }
    /**
     * 此方法用于求两个参数的和
     *  会将两个参数 转换为数字 求和
     * @param s1  字符串参数1
     * @param s2  字符串参数2
     */
    public static void sum(String s1,String s2){
        int sum = Integer.parseInt(s1)+Integer.parseInt(s2);
        System.out.println("和是:"+sum);
    }
}
