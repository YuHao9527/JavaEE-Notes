package com.wln.dp.strategy;

public class Travel {

    public void travleType(String type){
        if("飞机".equals(type)){
            byAir();
        }else if("火车".equals(type)){
            byTrain();
        }else  if("开车".equals(type)){
            byCar();
        }else{
            System.out.println("参数有误,暂未提供该方式！");
        }
    }

    public void byAir(){
        System.out.println("乘坐飞机出行.......");
    }

    public void byTrain(){
        System.out.println("乘坐火车出行.......");
    }

    public void byCar(){
        System.out.println("开车出行.......");
    }
}
