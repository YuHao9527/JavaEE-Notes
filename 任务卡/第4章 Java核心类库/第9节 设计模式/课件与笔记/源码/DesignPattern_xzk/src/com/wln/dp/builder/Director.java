package com.wln.dp.builder;

import java.util.ArrayList;

public class Director {

    private ArrayList<String> sequence=new ArrayList<>();
    private  BenzBuilder benzBuilder=new BenzBuilder();
    private  BMWBuilder bmwBuilder=new BMWBuilder();

    /**
     * 奔驰模型A，先start,在停止 其他啥都没有
     * @return
     */
    public Benz getABenz(){
        this.sequence.clear();
        this.sequence.add("start");
        this.sequence.add("stop");
        this.benzBuilder.setSequence(sequence);
        return (Benz) this.benzBuilder.getCarModel();
    }

    /**
     * 奔驰模型B，先发动引擎，start,在停止
     * @return
     */
    public Benz getBBenz(){
        this.sequence.clear();
        this.sequence.add("engineboom");
        this.sequence.add("start");
        this.sequence.add("stop");
        this.benzBuilder.setSequence(sequence);
        return (Benz) this.benzBuilder.getCarModel();
    }

    /**
     * 宝马模型C
     * @return
     */
    public BMW getCBMW(){
        this.sequence.clear();
        this.sequence.add("start");
        this.sequence.add("engineboom");
        this.sequence.add("alarm");
        this.sequence.add("stop");
        this.bmwBuilder.setSequence(sequence);
        return (BMW) this.bmwBuilder.getCarModel();
    }
    //其他内容:其他顺序的模型自行定义
}
