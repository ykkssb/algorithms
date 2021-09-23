package com.eureka.test.testu.deque;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * <p></p>
 *
 * @Author : Eric
 * @Date: 2021-09-18 09:37
 */
public class LinkedListTest {
    public static void main(String[] args) {
        Queue<String > p = new LinkedList<>();
        p.add("A");
        p.offer("B");
        p.add("C");

        while (!p.isEmpty()) {
            System.out.println(p.poll());
        }

        Deque<String> dq = new LinkedList<>();
        dq.push("a");
        dq.push("b");
        dq.add("c");
        dq.add("d");
        dq.add("e");

        while (!dq.isEmpty()) {
            System.out.println(dq.remove());
        }
    }
}
