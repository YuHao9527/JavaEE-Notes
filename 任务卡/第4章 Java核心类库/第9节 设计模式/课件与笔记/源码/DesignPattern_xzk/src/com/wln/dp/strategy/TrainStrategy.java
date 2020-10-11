package com.wln.dp.strategy;
//具体策略类
public class TrainStrategy implements  TravelStrategy{
    @Override
    public void travelType() {
        System.out.println("乘坐火车出行.......");
    }
}
