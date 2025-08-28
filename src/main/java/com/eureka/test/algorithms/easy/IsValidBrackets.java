package com.eureka.test.algorithms.easy;

import com.google.common.collect.Maps;

import java.util.ArrayDeque;
import java.util.Deque;
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
        Deque<Character> list = new ArrayDeque<>();
        for(int i =0 ;i<s.length();i++)      {
            char c  = s.charAt(i);
            if(c=='('||c=='['|| c=='{'){
                list.add(c);
            }else if(c==')' && (list.isEmpty() || list.peekLast()!='(')){
                return false;
            }else if(c==']' && (list.isEmpty() || list.peekLast()!='[')){
                return false;
            }else if(c=='}' && (list.isEmpty() || list.peekLast()!='{')){
                return false;
            }else{
                list.removeLast();
            }


        }
        return true && list.isEmpty();
    }

    public static void main(String[] args) {
        String s = "(([]))";
        IsValidBrackets b = new IsValidBrackets();
        System.out.println(b.isValid(s));
    }
}
