package com.eureka.test.designmodel.observer;

/**
 * <p></p>
 *
 * @Author : Eric
 * @Date: 2021-07-13 14:31
 */
public class ConcreteObserver1 implements Observer {
    @Override
    public void response() {
        System.out.println("具体观察者1作出反应！");
    }
}
