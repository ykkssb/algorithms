package com.eureka.test.designmodel.observer;

/**
 * <p></p>
 *
 * @Author : Eric
 * @Date: 2021-07-13 14:32
 */
public class main {

    public static void main(String[] args) {
        Subject subject = new ConcreteSubject();
        Observer obs1 = new ConcreteObserver1();
        Observer obs2 = new ConcreteObserver2();
        subject.add(obs1);
        subject.add(obs2);
        subject.notifyObserver();
    }
}
