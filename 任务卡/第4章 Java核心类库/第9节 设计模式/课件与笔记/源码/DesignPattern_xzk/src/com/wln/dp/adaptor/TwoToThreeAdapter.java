package com.wln.dp.adaptor;

public class TwoToThreeAdapter implements ThreePower{

    private TwoPower twoPower;

    public TwoToThreeAdapter(TwoPower twoPower) {
        this.twoPower = twoPower;
    }

    @Override
    public void powerByThree() {
        twoPower.powerByTwo();
        System.out.println("通过适配器转换为三项电");
    }
}
