package com.eureka.test.algorithms.test;

import java.lang.reflect.Field;

/**
 * <p></p>
 *
 * @Author : Eric
 * @Date: 2020-04-01 10:54
 */
public class IntegerCacheEquals {

    private static Integer in = 127;

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
//        Integer a = 127;
//        Integer b = 127;
//        Field nameField = Integer.getClass().getDeclaredField("IntegerCache");
//        nameField.setAccessible(true);
//        nameField.set(in, 129);

//        Field f = in.getClass().getDeclaredField("modifiers");
//        f.setAccessible(true);

//        f.setInt(in, nameField.getModifiers());
//        System.out.println(a == b);
        System.out.println(in);
    }
}
