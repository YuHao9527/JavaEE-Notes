package com.wln.dp.observer;
//具体观察者：粉丝
public class Fans implements Observer {
    @Override
    public void update(String context) {
        System.out.println("粉丝：观察到明星活动");
        this.action(context);
    }

    private void action(String context){
        System.out.println(context+"----->好可爱啊啊啊啊啊啊啊啊啊...........");
    }
}
