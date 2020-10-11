package com.wln.dp.builder;

import java.util.ArrayList;

public class Client {
    public static void main(String[] args) {
        Director director=new Director();
        //各个类型的
        System.out.println("奔驰A----");
        director.getABenz().run();
        System.out.println("奔驰B----");
        director.getBBenz().run();
        System.out.println("宝马C----");
        director.getCBMW().run();
    }
    public static void main2(String[] args) {
        //存放顺序
        ArrayList<String> sequence=new ArrayList<>();
        sequence.add("engineBoom");
        sequence.add("start");
        sequence.add("stop");
        //来一个奔驰车模型的创建者
        BenzBuilder benzBuilder=new BenzBuilder();
        //设置顺序
        benzBuilder.setSequence(sequence);
        //生产
        Benz benz= (Benz) benzBuilder.getCarModel();
        benz.run();
        //按照同样的顺序，再来一个宝马车
        BMWBuilder bmwBuilder=new BMWBuilder();
        bmwBuilder.setSequence(sequence);
        BMW bmw= (BMW) bmwBuilder.getCarModel();
        bmw.run();
    }
    public static void main1(String[] args) {
        Benz benz=new Benz();
        //顺序
        ArrayList<String> list=new ArrayList<>();
        list.add("engineBoom");
        list.add("start");
        list.add("stop");
        benz.setSequence(list);
         benz.run();
    }
}
