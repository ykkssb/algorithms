package com.eureka.test.designmodel.observer.event;

/**
 * <p></p>
 *
 * @Author : Eric
 * @Date: 2021-07-13 14:43
 */
public class Main {
    public static void main(String[] args) {
        BellEventSource eventSource = new BellEventSource();
        StuEventListener st = new StuEventListener();
        TeachEventListener te = new TeachEventListener();
        eventSource.addPersonListener(te);
        eventSource.addPersonListener(st);
        eventSource.ring(true);
        System.out.println("------------");
        eventSource.ring(false);

    }
}
