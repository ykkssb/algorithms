package com.eureka.test.algorithms.test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Random;

/**
 * <p></p>
 *
 * @Author : Eric
 * @Date: 2020-04-01 10:54
 */
public class IntegerCacheEquals {

    private static Integer in = 127;

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, ClassNotFoundException {
        Integer a = 127;
        Integer b = 127;
        Class<?> clazz = Class.forName("java.lang.Integer$IntegerCache");
        Field nameField = clazz.getDeclaredField("cache");
        nameField.setAccessible(true);

        Integer[] cache = (Integer[]) nameField.get(clazz);
        // Rewrite the Integer cache
        for (int i = 0; i < cache.length; i++) {
            cache[i] = new Random().nextInt(cache.length);
        }

        Field modifiers = nameField.getClass().getDeclaredField("modifiers");
        modifiers.setAccessible(true);
        modifiers.setInt(nameField, nameField.getModifiers() & ~Modifier.FINAL);

        nameField.set(clazz, 1);

        System.out.println(a == b);
        System.out.println(in);
    }
}
