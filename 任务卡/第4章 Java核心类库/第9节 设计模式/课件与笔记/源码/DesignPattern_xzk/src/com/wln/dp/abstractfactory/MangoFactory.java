package com.wln.dp.abstractfactory;

public class MangoFactory implements BreadFactory{
    @Override
    public Bread createPolorBearBread() {
        return new MangoPolorBearBread();
    }

    @Override
    public Bread createBlackBearBread() {
        return new MangoBlackBearBread();
    }

    @Override
    public Bread createBrownBearBread() {
        return new MangoBrownBearBread();
    }
}
