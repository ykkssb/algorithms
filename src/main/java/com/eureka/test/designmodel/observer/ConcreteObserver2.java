package com.eureka.test.designmodel.observer;

/**
 * <p></p>
 *
 * @Author : Eric
 * @Date: 2021-07-13 14:31
 */
public class ConcreteObserver2 implements Observer {
    @Override
    public void response() {
        System.out.println("具体观察者2作出反应！");
    }
}
