package com.wln.dp.abstractfactory;

public class PineappleFactory implements BreadFactory{
    @Override
    public Bread createPolorBearBread() {
        return new PineappPolorkBearBread();
    }

    @Override
    public Bread createBlackBearBread() {
        return new PineappBlackBearBread();
    }

    @Override
    public Bread createBrownBearBread() {
        return new PineappBrownBearBread();
    }
}
