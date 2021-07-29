package com.eureka.test.designmodel.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * <p></p>
 *
 * @Author : Eric
 * @Date: 2021-07-13 14:28
 */
public abstract class Subject {
    protected List<Observer> observers = new ArrayList<Observer>();

    //增加观察者方法
    public void add(Observer observer) {
        observers.add(observer);
    }

    //删除观察者方法
    public void remove(Observer observer) {
        observers.remove(observer);
    }

    //通知观察者方法
    public abstract void notifyObserver();
}
