package com.wln.dp.adaptor;

public class Client {

    public static void main(String[] args) {
        //现在只有一个两项插座供电
        TwoPower twoPower=new TwoPower();
        //通过适配器转换
        ThreePower threePower=new TwoToThreeAdapter(twoPower);
        //手机
        Phone phone=new Phone(threePower);
        phone.rechange();
        phone.tackePicture();
;    }
}
