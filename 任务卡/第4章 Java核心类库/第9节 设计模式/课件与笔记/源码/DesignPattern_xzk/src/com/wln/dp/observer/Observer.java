package com.wln.dp.observer;
//观察者接口
public interface Observer {
    //一旦发现别人有动静，自己就行动
    void update(String context);
}
