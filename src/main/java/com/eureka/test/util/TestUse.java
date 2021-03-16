package com.eureka.test.util;

import ch.qos.logback.core.util.TimeUtil;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 * <p></p>
 *
 * @Author : Eric
 * @Date: 2021-02-28 13:32
 */
public class TestUse {
    ThreadLocal tt = new ThreadLocal();

    public static void main(String[] args) {
        int i = 3;
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

        Map<String, String> map = new ConcurrentHashMap<>();
        for (int j = 0; j < 11; j++) {
            map.put("" + j, "b");
        }
        System.out.println((1<<31 +1) >2);
        map.put("b" + i, "b");

//        list.add("1");
//        System.out.println(list.get(0));
    }
}
