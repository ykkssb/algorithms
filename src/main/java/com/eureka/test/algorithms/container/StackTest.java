package com.eureka.test.algorithms.container;

import java.util.Stack;

/**
 * <p>先进先出栈</p>
 *
 * @Author : Eric
 * @Date: 2020-03-20 19:20
 */
public class StackTest {

    public static void main(String[] args) {
        Stack<String> stack = new Stack<String>();

        stack.push("a");
        stack.push("b");
        stack.push("c");
        System.out.println(stack);

//
//        System.out.println(stack.remove("a"));
//        System.out.println(stack);
//        System.out.println(stack.peek());
//
//        System.out.println(stack);
//        System.out.println(stack.size());
        for (int i = 0; i <= stack.size(); i++) {
            System.out.println(stack.pop());
        }

        System.out.println(stack);
//        for (stack.elementAt())
    }
}
