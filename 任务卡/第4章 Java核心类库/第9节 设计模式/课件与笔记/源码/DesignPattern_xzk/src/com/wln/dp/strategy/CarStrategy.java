package com.wln.dp.strategy;
//具体策略类
public class CarStrategy implements  TravelStrategy{
    @Override
    public void travelType() {
        System.out.println("开车出行.......");
    }
}
