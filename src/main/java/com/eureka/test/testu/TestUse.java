package com.eureka.test.testu;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <p></p>
 *
 * @Author : Eric
 * @Date: 2021-02-28 13:32
 */
public class TestUse {


    public static void main(String[] args) throws InterruptedException {
        ThreadLocal<Map<String, String>> tt = new ThreadLocal<Map<String, String>>();
        Runnable target;
        Thread t1 = new Thread(()->{
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("11111");
        });
        t1.start();
        t1.interrupt();

        System.out.println("22222");

//        String[] st = {"1", "2"};
//        System.out.println( String.join("-", st));

//        Map<String, String> mp = new HashMap<>();

//        Map<String, String> map = new ConcurrentHashMap<>();
//        map.putIfAbsent("1", "2");
//        for (int j = 0; j < 11; j++) {
//            map.put("" + j, "b");
//        }
//

//
//        System.out.println((1 << 31 + 1) > 2);
//        map.put("b" + 1, "b");

    }
}
