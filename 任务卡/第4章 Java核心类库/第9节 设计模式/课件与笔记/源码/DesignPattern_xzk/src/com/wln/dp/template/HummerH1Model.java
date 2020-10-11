package com.wln.dp.template;

public class HummerH1Model extends HummerModel{
    private boolean alarmFlag=true;//要鸣笛

    public void setAlarmFlag(boolean alarmFlag) {
        this.alarmFlag = alarmFlag;
    }

    @Override
    protected boolean isAlarm() {
        return this.alarmFlag;
    }

    @Override
    public void start() {
        System.out.println("悍马H1启动......");
    }

    @Override
    public void stop() {
        System.out.println("悍马H1停车......");
    }

    @Override
    public void alarm() {
        System.out.println("悍马H1鸣笛......");
    }

    @Override
    public void enginueBoom() {
        System.out.println("悍马H1引擎轰鸣......");
    }


}
