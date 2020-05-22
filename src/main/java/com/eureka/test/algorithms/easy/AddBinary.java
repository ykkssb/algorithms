package com.eureka.test.algorithms.easy;

/**
 * <p>二进制求和</p>
 * https://leetcode-cn.com/problems/add-binary/
 *
 * @Author : Eric
 * @Date: 2020-05-21 19:58
 */
public class AddBinary {


    public String addBinary(String a, String b) {
        int n = a.length(), m = b.length();
        if (n < m) {
            return addBinary(b, a);
        }
        int l = Math.max(n, m);
        StringBuffer sb = new StringBuffer();
        int res = 0;
        int j = m - 1;
        for (int i = l - 1; i >= 0; i--) {
            if (a.charAt(i) == '1') res++;
            if (j >= 0 && b.charAt(j) == '1') res++;

            if (res % 2 == 0) {
                sb.append('0');
            } else {
                sb.append('1');
            }

            res = res / 2;
            j--;
        }

        if (res == 1) {
            sb.append('1');
        }
        sb.reverse();

        return sb.toString();
    }

    public static void main(String[] args) {
        AddBinary add = new AddBinary();
        String a = "11";
        String b = "1";
        System.out.println(add.addBinary(a, b));
    }
}
