package com.eureka.test.algorithmsv2.array;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>1656. 设计有序流</p>
 * https://leetcode-cn.com/problems/design-an-ordered-stream/
 *
 * @Author : Eric
 * @Date: 2021-03-26 00:48
 */
public class OrderedStream {
    String[] a;
    int ptr = 1;

    public OrderedStream(int n) {
        a = new String[n];


    }
    // todo v3
    public List<String> insert(int idKey, String value) {
        a[idKey - 1] = value;
        if (a[ptr - 1] == null) {
            return new ArrayList<>();
        }
        List<String> list = new ArrayList<>();
        while (ptr <= a.length && a[ptr - 1] != null) {
            list.add(a[ptr - 1]);
            ptr++;
        }

        return list;
    }

    public static void main(String[] args) {
        OrderedStream os = new OrderedStream(5);
        System.out.println(os.insert(3, "ccccc"));
        System.out.println(os.insert(1, "aaaaa"));
        System.out.println(os.insert(2, "bbbbb"));
        System.out.println(os.insert(5, "eeeee"));
        System.out.println(os.insert(4, "ddddd"));
    }
}
