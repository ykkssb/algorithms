package com.eureka.test.algorithms.normal;

/**
 * <p>字符串转换整数</p>
 *
 * @Author : Eric
 * @Date: 2020-03-10 15:09
 */
public class AtoiNumber {

    public static int atoi(String str) {
        int n = str.length();
        int ret = 0;
        int index = 0;
        if (n == 0) {
            return ret;
        }


        while (index < n) {
            if (str.charAt(index) != ' ') {
                break;
            }
            index++;
        }

        int sign = 1;
        int f = 0;

        if (index < n && str.charAt(index) == '+') {
            index++;
            f++;
        }

        if (index < n && str.charAt(index) == '-') {
            sign = -1;
            index++;
            f++;
        }

        if (f > 1) {
            return ret;
        }


        while (index < n) {
            Character a = str.charAt(index);
            if (a > '9' || a < '0') {
                break;
            }
            //'0'的ASCII码是48，'1'的是49，这么一减就从就可以得到真正的整数值
            int tmp = a - 48;


            if (Integer.MAX_VALUE / 10 < ret || (Integer.MAX_VALUE / 10 == ret && Integer.MAX_VALUE % 10 < tmp)) {
                ret = Integer.MAX_VALUE;
                break;
            } else if (Integer.MIN_VALUE / 10 > ret || (Integer.MIN_VALUE / 10 == ret && Math.abs(Integer.MIN_VALUE % 10) < tmp)) {
                ret = Integer.MIN_VALUE;
                break;
            }

            ret = ret * 10 + sign * tmp;
            index++;

        }
        return ret;
    }

    public static void main(String[] args) {
//        String s = "-2147483649";
        String s = "-2147483647";
        System.out.println(atoi(s));
    }
}
