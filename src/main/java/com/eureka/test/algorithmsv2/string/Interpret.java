package com.eureka.test.algorithmsv2.string;

/**
 * <p>1678. 设计 Goal 解析器 </p>
 * https://leetcode-cn.com/problems/goal-parser-interpretation/
 *
 * @Author : Eric
 * @Date: 2021-01-26 15:13
 */
public class Interpret {
    public String interpret(String command) {
        StringBuffer sb = new StringBuffer();

        char[] ch = command.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == 'G') {
                sb.append("G");
            } else if (ch[i] == ')' && ch[i - 1] == '(') {
                sb.append("o");
            } else if (ch[i] == ')' && ch[i - 1] != '(') {
                sb.append("al");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Interpret i = new Interpret();
        System.out.println(i.interpret("G()(al)"));
    }
}
