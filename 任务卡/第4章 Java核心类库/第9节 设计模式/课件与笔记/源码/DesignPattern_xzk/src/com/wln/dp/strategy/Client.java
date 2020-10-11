package com.wln.dp.strategy;

import java.util.Random;

public class Client {

    public static void main(String[] args) {
        TravelStrategy travelStrategy=null;
        for(int i=0;i<=3;i++){
            System.out.println("要去杭州玩啦！可以有以下的选择方式：");
            System.out.println("1、飞机");
            System.out.println("2、火车");
            System.out.println("3、开车");
            System.out.println("随机选择一种！");
            int num=new Random().nextInt(3)+1;
            if(num==1){
                travelStrategy=new AirStrategy();
            }else if(num==2){
                travelStrategy=new TrainStrategy();
            }else{
                travelStrategy=new CarStrategy();
            }
            Traveler lina=new Traveler(travelStrategy);
            lina.travleStyle();
        }
    }
}
