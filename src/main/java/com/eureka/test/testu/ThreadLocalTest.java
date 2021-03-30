package com.eureka.test.testu;

import org.apache.commons.lang.math.RandomUtils;

import java.util.Random;

/**
 * <p></p>
 *
 * @Author : Eric
 * @Date: 2021-03-26 15:12
 */
public class ThreadLocalTest {
    static ThreadLocal<String> local = new ThreadLocal<String>();

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                local.set("a_" + RandomUtils.nextInt());

                try {
                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread().getName() + "==="+ local.get());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, "Thread--" + i).start();
        }

        Thread.sleep(60000);
    }
}
