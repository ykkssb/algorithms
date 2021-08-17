package com.eureka.test.algorithmsv2.string;

import java.util.Stack;

/**
 * <p>1694. 重新格式化电话号码</p>
 * https://leetcode-cn.com/problems/reformat-phone-number
 *
 * @Author : Eric
 * @Date: 2021-01-28 16:05
 */
public class ReformatNumber {
    public static void main(String[] args) {
        String s = "testu.email+alex@leetcode.com";
        System.out.println(s.substring(0,s.indexOf("@")));
        System.out.println(s.substring(s.indexOf("@")));
        ReformatNumber rn = new ReformatNumber();
        System.out.println(rn.reformatNumber("123 4-56870"));
    }

    public String reformatNumber(String number) {
        String res = "";
        String num  = "";
        for(int i=0;i<number.length(); ++i){
            if(isNum(number.charAt(i)))
                num += number.charAt(i);
        }
        int len = num.length();
        int c  = len %3;
        for(int i=0;i< len ; i+=3){
            res += num.charAt(i);
            res += num.charAt(i+1) ;
            if(c==1 &&  i+4 >= len){
                i--;
            }else if(i+2<len){
                res += num.charAt(i+2);
            }
            res+= "-";
        }
        res = res.substring(0, res.length()-1);
        return res;
    }
    public boolean isNum(int i){
        if(i>=48 && i<=57){
            return true;
        }
        return false;
    }
    // 1-2-3-4-5-6-7-8
    // 8-7-6-5-4-3-2-1
    /**
     * 6-7-8-3-4-5-2-1
     */
}
