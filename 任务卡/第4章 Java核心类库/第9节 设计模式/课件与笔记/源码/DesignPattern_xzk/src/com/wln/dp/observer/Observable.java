package com.wln.dp.observer;
//被观察者：那些明星们
public interface Observable {
    //添加一个观察者
    void addObserver(Observer observer);
    //删除一个观察者
    void deleteObserver(Observer observer);
    //当被观察者有所行动的时候，通知观察者
     void notifyObserver(String context);
}
