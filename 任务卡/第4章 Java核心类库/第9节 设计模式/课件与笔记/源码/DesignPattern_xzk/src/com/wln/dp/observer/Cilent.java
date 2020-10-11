package com.wln.dp.observer;

public class Cilent {
    public static void main(String[] args) {
        //三个具体的观察者
        Observer fan=new Fans();
        Observer reportor=new Reporter();
        Observer shop=new TaobaoShop();
        //定义被观察者
        ZhaoLiYing zhao=new ZhaoLiYing();
        //三个观察者都在观察者赵丽颖
        zhao.addObserver(fan);
        zhao.addObserver(reportor);
        zhao.addObserver(shop);
        //赵丽颖行动
        zhao.eat();
        zhao.action();
    }
}
