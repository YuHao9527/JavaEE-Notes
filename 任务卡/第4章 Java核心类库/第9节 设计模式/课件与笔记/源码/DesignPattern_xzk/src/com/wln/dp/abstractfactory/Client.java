package com.wln.dp.abstractfactory;

public class Client {
    public static void main(String[] args) {
        //来一个专门烤菠萝馅儿的面包的烤箱
        BreadFactory pineappler=new PineappleFactory();
        //来一个专门烤芒格面包的烤箱
        BreadFactory mango=new MangoFactory();
        //生产
        System.out.println("生产第1批面包");
        Bread b1=pineappler.createBlackBearBread();
        Bread b2=mango.createBlackBearBread();
        b1.getColor();
        b1.getType();
        b2.getColor();
        b2.getType();
        System.out.println("生产第2批面包");
        Bread b21=pineappler.createPolorBearBread();
        Bread b22=mango.createPolorBearBread();
        b21.getColor();
        b21.getType();
        b22.getColor();
        b22.getType();
        System.out.println("生产第3批面包");
        Bread b31=pineappler.createBrownBearBread();
        Bread b32=mango.createBrownBearBread();
        b31.getColor();
        b31.getType();
        b32.getColor();
        b32.getType();
    }
}
