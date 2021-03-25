package com.eureka.test.test;

/**
 * <p></p>
 *
 * @Author : Eric
 * @Date: 2021-03-24 14:51
 */
public class TestJoin {
    public static void main(String[] args) throws InterruptedException {
        // TODO Auto-generated method stub
        System.out.println(Thread.currentThread().getName() + " start");
        ThreadTest t1 = new ThreadTest("A");
        ThreadTest t2 = new ThreadTest("B");
        ThreadTest t3 = new ThreadTest("C");
        System.out.println("t1start");
        System.out.println("t2start");
        System.out.println("t3start");
        t1.start();
        t2.start();
        t1.join();
        t3.start();
        System.out.println(Thread.currentThread().getName() + " end");
    }


    static class ThreadTest extends Thread {
        private String name;

        public ThreadTest(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            for (int i = 1; i <= 10; i++) {
                System.out.println(name + "-" + i);
            }

        }
    }
}