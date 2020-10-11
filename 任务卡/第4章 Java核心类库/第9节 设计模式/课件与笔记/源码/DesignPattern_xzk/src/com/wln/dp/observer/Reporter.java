package com.wln.dp.observer;
//具体的观察者：记者
public class Reporter implements  Observer{
    @Override
    public void update(String context) {
        System.out.println("记者：观察到明星活动");
        this.action(context);
    }

    private void action(String context){
        System.out.println(context+"-----> 演技高，敬业...........");
    }
}
