package com.wln.dp.builder;

import java.util.ArrayList;

public class BMWBuilder extends CarBuiler{

    private BMW bmw=new BMW();

    @Override
    public void setSequence(ArrayList<String> sequence) {
        this.bmw.setSequence(sequence);
    }

    @Override
    public CarModel getCarModel() {
        return bmw;
    }
}
