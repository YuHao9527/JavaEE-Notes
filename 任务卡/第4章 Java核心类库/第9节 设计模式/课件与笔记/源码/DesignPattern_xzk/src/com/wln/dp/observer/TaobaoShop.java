package com.wln.dp.observer;
//具体的观察者：淘宝店主
public class TaobaoShop implements  Observer{
    @Override
    public void update(String context) {
        System.out.println("淘宝店主：观察到明星活动");
        this.action(context);
    }

    private void action(String context){
        System.out.println(context+"-----> 同款商品准备上架..........");
    }
}
