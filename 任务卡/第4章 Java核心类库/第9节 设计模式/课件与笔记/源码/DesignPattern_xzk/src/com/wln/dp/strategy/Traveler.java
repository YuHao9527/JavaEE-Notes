package com.wln.dp.strategy;
//策略上下文角色StrategyContext
public class Traveler {
    //出行策略
    private TravelStrategy travelStrategy;

    //设置出行策略
    public Traveler(TravelStrategy travelStrategy) {
        this.travelStrategy = travelStrategy;
    }

    public void travleStyle(){
        this.travelStrategy.travelType();
    }
}
