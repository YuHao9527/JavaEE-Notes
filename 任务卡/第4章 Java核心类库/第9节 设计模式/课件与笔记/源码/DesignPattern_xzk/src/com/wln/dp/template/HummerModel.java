package com.wln.dp.template;

public abstract class HummerModel {
    public abstract void start();
    public abstract void stop();
    public abstract void alarm();
    public abstract void enginueBoom();
    public void run(){
        this.start();
        this.enginueBoom();
        //要不要响喇叭，由客户决定
        if(this.isAlarm()) {
            this.alarm();
        }
        this.stop();
    }

    //钩子方法：默认喇叭可以响
    protected boolean isAlarm(){
        return true;
    }
}
