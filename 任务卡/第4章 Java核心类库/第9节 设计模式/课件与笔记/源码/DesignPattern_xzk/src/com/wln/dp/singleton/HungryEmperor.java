package com.wln.dp.singleton;
//皇帝类
public class HungryEmperor {
    //实例化一个皇帝
    private static final HungryEmperor emperor=new HungryEmperor();
    //构造方法私有，避免在类的外部创建对象
    private HungryEmperor() {
    }
    //提供一个产生实例的方法
    public static HungryEmperor getInstance(){
        return emperor;
    }
    public void work(){
        System.out.println("我是皇帝XXX：有事起奏，无事退朝！");
    }
}
