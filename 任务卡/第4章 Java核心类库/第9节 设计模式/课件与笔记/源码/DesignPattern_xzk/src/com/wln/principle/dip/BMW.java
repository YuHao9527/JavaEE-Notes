package com.wln.principle.dip;

import javax.sound.midi.Soundbank;
//宝马车
public class BMW implements ICar{
    @Override
    public void run(){
        System.out.println("宝马车飞驰------------");
    }
}
