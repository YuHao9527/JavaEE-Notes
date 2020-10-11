package com.wln.dp.abstractfactory;

import com.wln.dp.abstractfactory.Bread;

public abstract class AbstractPolarBearBread implements Bread {
    @Override
    public void getColor() {
        System.out.println("烤的时间有点短的--北极熊面包");
    }
}
