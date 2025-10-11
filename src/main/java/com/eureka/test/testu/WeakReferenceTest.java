package com.eureka.test.testu;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/**
 * @author : yujie.wang
 * @date: 2025-10-10 17:29
 */
public class WeakReferenceTest {

    public static void main(String[] args) throws Exception {
        Map<WeakReference<Integer>, WeakReference<Integer>> map = new HashMap<>(8);
//        WeakReference<Integer> key = new WeakReference<>(666);
//        WeakReference<Integer> value = new WeakReference<>(777);
        WeakReference<Integer> key = new WeakReference<>(1);
        WeakReference<Integer> value = new WeakReference<>(127);
        map.put(key,value);
        System.out.println("put success");
        Thread.sleep(1000);
        System.gc();
        System.out.println("get " + map.get(key).get());
    }

}
