package com.wln.dp.abstractfactory;

import com.wln.dp.abstractfactory.AbstractPolarBearBread;
import com.wln.dp.factory.AbstarctBreadFactory;
import com.wln.dp.factory.Bread;

public class MangoPolorBearBread extends AbstractPolarBearBread{

    @Override
    public void getType() {
        System.out.println("北极熊-----芒果馅儿----");
    }
}
