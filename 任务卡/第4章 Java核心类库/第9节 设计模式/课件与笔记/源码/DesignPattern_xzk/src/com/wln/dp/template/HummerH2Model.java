package com.wln.dp.template;

public class HummerH2Model extends HummerModel{
    @Override
    public void start() {
        System.out.println("悍马H2启动......");
    }

    @Override
    public void stop() {
        System.out.println("悍马H2停车......");
    }

    @Override
    public void alarm() {
        System.out.println("悍马H2鸣笛......");
    }

    @Override
    public void enginueBoom() {
        System.out.println("悍马H2引擎轰鸣......");
    }

    //默认不鸣笛
    @Override
    protected boolean isAlarm() {
        return false;
    }
}
