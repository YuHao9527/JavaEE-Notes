package com.wln.dp.observer;

import java.util.ArrayList;

public class ZhaoLiYing  implements  IStar,Observable{
    private ArrayList<Observer> observerList=new ArrayList<>();
    @Override
    public void eat() {
        System.out.println("颖宝吃饭ing........");
        this.notifyObserver("赵丽颖开始吃饭了!!!");
    }

    @Override
    public void action() {
        System.out.println("颖宝电视剧宣传中........");
        this.notifyObserver("赵丽颖宣传电视剧!!!");
    }

    @Override
    public void addObserver(Observer observer) {
        this.observerList.add(observer);
    }

    @Override
    public void deleteObserver(Observer observer) {
        this.observerList.remove(observer);
    }

    @Override
    public void notifyObserver(String context) {
        for (Observer observer : observerList) {
            observer.update(context);
        }
    }
}
