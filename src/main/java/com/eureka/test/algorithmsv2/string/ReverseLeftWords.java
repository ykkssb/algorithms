package com.eureka.test.algorithmsv2.string;

import java.util.Arrays;

/**
 * <p>剑指 Offer 58 - II. 左旋转字符串</p>
 * https://leetcode-cn.com/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof/
 *
 * @Author : Eric
 * @Date: 2021-01-26 14:34
 */
public class ReverseLeftWords {
    public String reverseLeftWords(String s, int n) {
        int l = 0, r= s.length()-1;
        char[] ch = s.toCharArray();
        while(l<r){
            while(l<r && !is(s.charAt(l))){
                l++;
            }
            while(r >l && !is(s.charAt(r))){
                r--;
            }
            char tmp = s.charAt(l);
            ch[l] = s.charAt(r);
            ch[r] = tmp;
            l++;
            r--;
        }

        return Arrays.toString(ch);
    }
    public boolean is(int i){
        if((i>=65 &&i<=90) || (i>=97 && i<=122)){
            return true;
        }
        return false;
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
        char[] c = {'a', 'b'};
        String str = Arrays.toString(c);//把字符数组当做参数传入，得到一个字符串对象
        System.out.println(str);
        System.out.println(sb.length());
        ReverseLeftWords r = new ReverseLeftWords();
        System.out.println(r.reverseLeftWords(s,2));
    }

}
