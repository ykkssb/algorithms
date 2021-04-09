package com.eureka.test.testu;

import sun.jvm.hotspot.runtime.VM;

/**
 * <p></p>
 *
 * @Author : Eric
 * @Date: 2021-03-24 15:31
 */
public class Num {
    public Num() {

    }

    private int num;

    public Num(int n) {
        this.num = n;
    }

    public synchronized void print() {
        System.out.println(Thread.currentThread().getName() + "_" + num++);
        try {
            Thread.sleep(500);
            notifyAll();
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
