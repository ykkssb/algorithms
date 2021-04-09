package com.eureka.test.algorithmsv2.string;

/**
 * <p>剑指 Offer 58 - II. 左旋转字符串</p>
 * https://leetcode-cn.com/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof/
 *
 * @Author : Eric
 * @Date: 2021-01-26 14:34
 */
public class ReverseLeftWords {
    public String reverseLeftWords(String s, int n) {
        if (s.length() <= n) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(s.substring(n - 1)).append(s.substring(0, n));
        return sb.toString();
    }


    public static void main(String[] args) {
        String s = "abcdef";
//        System.out.println(s.substring(1, 5));
//        System.out.println(s.substring(2));
        String number = "ab d-d";
        number.replace(s.charAt(0),'C') ;
        System.out.println(number);
        StringBuffer sb = new StringBuffer();
        for(char c:number.toCharArray()){
            if(c!=' ' && c!='-'){
                sb.append(c);
            }
        }
        System.out.println(sb.length());

    }

}
