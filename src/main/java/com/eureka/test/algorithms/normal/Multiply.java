package com.eureka.test.algorithms.normal;

/**
 * <p>字符串相乘</p>
 *
 * @Author : Eric
 * @Date: 2020-04-07 19:24
 */
public class Multiply {

    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        int[] ans = new int[num1.length() + num2.length()];
        for (int i = num1.length() - 1; i >= 0; i--) {
            int n1 = num1.charAt(i) - '0';
            for (int j = num2.length() - 1; j >= 0; j--) {
                int n2 = num2.charAt(j) - '0';
                int sum = ans[i + j + 1] + n1 * n2;
                ans[i + j + 1] = sum % 10;
                ans[i + j] += sum / 10;

            }
        }

        StringBuffer res = new StringBuffer();
        for (int i = 0; i < ans.length; i++) {
            if (i == 0 && ans[i] == 0) {
                continue;
            }
            res.append(ans[i]);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String n1 = "123", n2 = "23";
        Multiply m = new Multiply();
        System.out.println(m.multiply(n1, n2));
    }

}

