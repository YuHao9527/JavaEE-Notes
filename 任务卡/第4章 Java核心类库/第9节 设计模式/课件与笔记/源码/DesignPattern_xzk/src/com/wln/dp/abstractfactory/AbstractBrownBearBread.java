package com.wln.dp.abstractfactory;

import com.wln.dp.abstractfactory.Bread;

public abstract class AbstractBrownBearBread implements Bread {
    @Override
    public void getColor() {
        System.out.println("烤的时间刚刚好的--布朗熊面包");
    }
}
