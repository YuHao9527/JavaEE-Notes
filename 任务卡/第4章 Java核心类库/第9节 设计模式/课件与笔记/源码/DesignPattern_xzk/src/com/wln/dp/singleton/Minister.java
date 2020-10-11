package com.wln.dp.singleton;
//大臣
public class Minister {
    public static void main(String[] args) {
        for(int i=1;i<=5;i++){
            Emperor emperor=Emperor.getInstance();
            System.out.print("第"+i+"天：");
            emperor.work();
        }
    }
}
