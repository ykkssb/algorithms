package com.eureka.test.algorithmsv2.string;

/**
 * 剑指 Offer 58 - I. 翻转单词顺序
 * https://leetcode-cn.com/problems/fan-zhuan-dan-ci-shun-xu-lcof/
 *
 * @Author : Eric
 * @Date: 2021-03-20 20:08
 */
public class ReverseWords {
    public String reverseWords(String s) {
        if(s==null|| "".equals(s)){
            return s;
        }
        String[] array = s.split(" ");
        StringBuffer sb = new StringBuffer();

        for (int i = array.length - 1; i >= 0; i--) {
            if (!"".equals( array[i]))
                sb.append(array[i]).append(" ");
        }
        if(array.length>0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        ReverseWords rw = new ReverseWords();

        System.out.println(rw.reverseWords("   "));
    }
}
