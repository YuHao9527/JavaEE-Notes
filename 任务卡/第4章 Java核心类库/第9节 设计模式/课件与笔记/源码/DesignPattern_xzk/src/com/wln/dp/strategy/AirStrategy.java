package com.wln.dp.strategy;
//具体策略类
public class AirStrategy implements  TravelStrategy{
    @Override
    public void travelType() {
        System.out.println("乘坐飞机出行.......");
    }
}
