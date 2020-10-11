package com.wln.dp.builder;

import java.util.ArrayList;

public class BenzBuilder extends CarBuiler{

    private Benz benz=new Benz();

    @Override
    public void setSequence(ArrayList<String> sequence) {
        this.benz.setSequence(sequence);
    }

    @Override
    public CarModel getCarModel() {
        return benz;
    }
}
