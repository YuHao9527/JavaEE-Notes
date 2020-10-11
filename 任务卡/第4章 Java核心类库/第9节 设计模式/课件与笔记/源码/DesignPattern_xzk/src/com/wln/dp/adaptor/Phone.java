package com.wln.dp.adaptor;

public class Phone {

    private ThreePower threePower;//期待三项充电

    public Phone(ThreePower threePower) {
        this.threePower = threePower;
    }

    public void rechange(){
        threePower.powerByThree();
        System.out.println("手机通过三项插座充电ing");
    }

    public  void  tackePicture(){
        System.out.println("拍了一张照片");
    }
}
