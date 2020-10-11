package com.wln.dp.abstractfactory;

import com.wln.dp.abstractfactory.Bread;

public abstract class AbstractBlackBearBread implements Bread {
    @Override
    public void getColor() {
        System.out.println("烤的时间有点长的--黑熊面包");
    }
}
