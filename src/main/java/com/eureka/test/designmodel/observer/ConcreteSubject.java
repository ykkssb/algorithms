package com.eureka.test.designmodel.observer;


/**
 * <p></p>
 *
 * @Author : Eric
 * @Date: 2021-07-13 14:29
 */
public class ConcreteSubject extends Subject {
    @Override
    public void notifyObserver() {
        System.out.println("具体目标发生改变...");
        System.out.println("--------------");
        for (Object obs : observers) {
            ((Observer) obs).response();
        }
    }
}
