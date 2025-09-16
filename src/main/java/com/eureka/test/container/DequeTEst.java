package com.eureka.test.container;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <p></p>
 *
 * @Author : Eric
 * @Date: 2020-04-06 21:18
 */
public class DequeTEst {

    public static void main(String[] args) {
        Deque<Integer> p = new ArrayDeque<>();
        p.add(1);
        p.add(2);
        p.add(3);

//        System.out.println(p.toString());
//        System.out.println(p.getLast());
//        System.out.println(p.peekLast());
//        System.out.println(p.peekFirst());
        System.out.println(p.offerLast(5));
        System.out.println(p.toString());
        System.out.println(p.offerFirst(9));
        System.out.println(p.toString());
        System.out.println(p.poll());
        System.out.println(p.pollLast());
        System.out.println(p.toString());
    }
}
