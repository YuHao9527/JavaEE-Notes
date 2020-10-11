package com.wln.dp.abstractfactory;

public interface BreadFactory {
    //创建北极熊面包
    Bread createPolorBearBread();
    //创建黑熊面包
   Bread createBlackBearBread();
    //创建布朗熊面包
    Bread createBrownBearBread();
}
