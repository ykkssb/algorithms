package com.eureka.test.algorithms.easy;

import com.google.common.collect.Maps;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * <p>是否有效括号</p>
 *
 * @Author : Eric
 * @Date: 2020-03-20 19:15
 */
public class IsValidBrackets {

    private static Map<Character, Character> map = new HashMap<>();

    public IsValidBrackets() {
        System.out.println("无参构造");
        map.put('}', '{');
        map.put(')', '(');
        map.put(']', '[');
    }

    /**
     * 时间复杂度：O(n)，因为我们一次只遍历给定的字符串中的一个字符并在栈上进行 O(1) 的推入和弹出操作。
     * 空间复杂度：O(n)
     *
     * @param s
     * @return
     */
    public Boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            Character c = s.charAt(i);

            if (map.containsKey(c)) {
                Character top = stack.isEmpty() ? 'A' : stack.pop();

                if (!top.equals(map.get(c))) {
                    return false;
                }
            } else {
                stack.push(c);
            }

        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "(([]))";
        IsValidBrackets b = new IsValidBrackets();
        System.out.println(b.isValid(s));
    }
}
