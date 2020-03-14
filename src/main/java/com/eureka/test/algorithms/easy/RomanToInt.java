package com.eureka.test.algorithms.easy;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.Objects;

/**
 * <p>罗马数字转整数</p>
 *
 * @Author : Eric
 * @Date: 2020-03-13 19:47
 */
public class RomanToInt {


    public static Integer romanToInt(String s) {
        int n = s.length();
        int sum = 0;
        int preNum = switchRoman(s.charAt(0));
        // IV
        for (int i = 1; i < n; i++) {
            int num = switchRoman(s.charAt(i));
            if (preNum < num) {
                sum -= preNum;
            } else {
                sum += preNum;
            }
            preNum = num;

        }
        sum += preNum;
        return sum;

    }

    public static Integer switchRoman(Character s) {
        switch (s) {
            case 'M':
                return 1000;
            case 'D':
                return 500;
            case 'C':
                return 100;
            case 'L':
                return 50;
            case 'X':
                return 10;
            case 'V':
                return 5;
            case 'I':
                return 1;
            default:
                return 0;


        }
    }


    public static void main(String[] args) {
//        String s = "IV";
//        String s = "III";
        String s = "MXXI";
//        System.out.println(s.substring(3, 4));
        System.out.println(romanToInt(s));
    }
}
