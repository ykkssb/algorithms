package com.eureka.test.algorithmsv2.string;

/**
 *
 647. 回文子串
 * https://leetcode.cn/problems/palindromic-substrings/submissions/658470912/
 * @author : yujie.wang
 * @date: 2025-09-01 16:39
 */
public class CountSubstrings {

    public int countSubstrings(String s) {
        int n = s.length();
        boolean[][] b = new boolean[n][n];
        int ans = 0;
        for (int i = n - 1; i >= 0; i--) {
            b[i][i] = true;
            ans++;
            for (int j = i + 1; j <n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    // 相邻2个字符
                    if (j - i == 1) {
                        b[i][j] = true;
                    } else{ // 多个字符 aba  aca abba [i+1][j-1] 其实求 b 是否 true
                        b[i][j] = b[i + 1][j - 1];
                    }
                    if(b[i][j]){
                        ans++;
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "aabaca";
        CountSubstrings c = new CountSubstrings();
        System.out.println(c.countSubstrings(s));
    }

}
