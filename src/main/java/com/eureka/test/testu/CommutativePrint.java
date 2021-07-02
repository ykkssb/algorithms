package com.eureka.test.testu;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <p></p>
 *
 * @Author : Eric
 * @Date: 2021-03-24 15:17
 */
public class CommutativePrint {


    public volatile boolean flag;

    public static void main(String[] args) throws InterruptedException {
//        Num n = new Num(0);
        Object b = new Object();
        ReentrantLock lock = new ReentrantLock();
        Condition c1 = lock.newCondition();
        Condition c2 = lock.newCondition();
        Semaphore s = new Semaphore(10);
        s.acquire();
        new Thread(() -> {
//            for (; ; ) {
//                synchronized (b){

                for (int i = 0; i <= 1; i++) {
                    lock.lock();
                    try {
                        c2.signal();
                        Thread.sleep(1);
                        System.out.println(Thread.currentThread().getName() + "_" + i);
                        c1.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        lock.unlock();
                    }
                }
//                }
//            }
        },"num"
        ).start();

        new Thread(() -> {
//            for (; ; ) {
                for (char i = 'a'; i <= 'b'; i++) {
                    lock.lock();
                    c1.signal();
                    System.out.println(Thread.currentThread().getName() + "_" + i);
                    try {
                        Thread.sleep(1);
                        c2.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        lock.unlock();
                    }
                }
//            }


    },"String").start();
}


}
