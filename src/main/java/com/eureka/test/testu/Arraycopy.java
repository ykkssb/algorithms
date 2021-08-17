package com.eureka.test.testu;

import java.util.Arrays;

/**
 * <p></p>
 *
 * @Author : Eric
 * @Date: 2021-08-05 17:24
 */
public class Arraycopy {
    public static void main(String[] args) {
        char[] a = {'a', 'b', 'c', 'd', 'e', 'f'},
                b = {'1', '2', '3', '4', '5', '6'};
        int[] c = {1, 2, 3, 4, 5, 6},
                d = {10, 20, 30, 40, 50, 60};
        System.arraycopy(a, 1, b, 0, 2);
//        System.arraycopy(c, 2, d, 2, c.length - 3);
        System.out.println("数组a的各个元素中的值：" + Arrays.toString(a));
        System.out.println("数组b的各个元素中的值：");
        System.out.println(Arrays.toString(b));
//        System.out.println("数组c的各个元素中的值：");
//        System.out.println(Arrays.toString(c));
//        System.out.println("数组d的各个元素中的值：");
//        System.out.println(Arrays.toString(d));
    }

}
