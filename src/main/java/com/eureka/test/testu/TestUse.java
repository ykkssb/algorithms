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
        System.out.println(Integer.SIZE);
        System.out.println(1 ^ 1);
        System.out.println(3 ^ 3);
//        BitSet bitSet = new BitSet();

//        t1.start();
//        t1.join();
//        System.out.println(i<<2);
//
//        String s = "abc";
//        System.out.println(s.length());
//
//        System.out.println(16>>>2);
//
//        List st = new ArrayList();
//
//        Arrays.asList("1");

        List<String> list = new ArrayList<String>();
        List<String> list2 = new LinkedList<>();
        Map<String, String> m2 = new HashMap<>();
        Runnable target;
        Thread t1 = new Thread();
        for (String s : list) {
        }

        String[] st = {"1", "2"};
        String.join("", st);


        Map<String, String> map = new ConcurrentHashMap<>();
        map.putIfAbsent("1", "2");
//        for (int j = 0; j < 11; j++) {
//            map.put("" + j, "b");
//        }
//
//        tt.set(m2);
//        tt.get();
//
//        System.out.println((1 << 31 + 1) > 2);
//        map.put("b" + 1, "b");

//        list.add("1");
//        System.out.println(list.get(0));
    }
}
