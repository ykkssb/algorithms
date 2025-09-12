package com.eureka.test.algorithmsv2.string.hard;

/**
 * https://leetcode.cn/problems/maximum-number-of-non-overlapping-palindrome-substrings/
 * 不重叠回文子字符串的最大数目
 * @author : yujie.wang
 * @date: 2025-09-09 15:34
 */
public class MaxPalindromes {

    public int maxPalindromes(String s, int k) {
        int n = s.length();
        boolean[][] b = new boolean [n][n];
        for(int i=n-1;i>=0;i--){
            b[i][i]=true;
            for(int j=i+1;j<n;j++){
                if(s.charAt(i)==s.charAt(j)){
                    if(j==i+1){
                        b[i][j] =true;
                    }else {
                        b[i][j] = b[i + 1][j - 1];
                    }
                }
            }
        }

        /**
         * 2. 动态规划状态定义：定义一个一维数组 dp，其中 dp[i] 表示处理到字符串的前 i 个字符时，能选取的最大回文子串数量。
         * 3. 状态转移：
         *     ◦ 对于每个位置 i，初始时 dp[i] 设置为 dp[i-1]，表示不选择以第 i-1 个字符结尾的回文串。
         *     ◦ 然后，枚举所有可能的起始位置 j（从 0 到 i-k），如果子串 s[j..i-1] 是回文串且长度至少为 k，
         *           则更新 dp[i] = max(dp[i], dp[j] + 1)。
         * 4. 结果提取：最终结果存储在 dp[n] 中，其中 n 是字符串的长度。
         *
         *  250912
         */
        int[]f = new int[n+1];
        for(int i=1;i<=n;i++){
            f[i] =f[i-1];
            for(int j=0;j<=i-k;j++){
                if(b[j][i-1]){
                    f[i] =Math.max(f[i],  f[j]+1);
                }
            }
        }
        return f[n];
    }

    public static void main(String[] args) {
        MaxPalindromes mp = new MaxPalindromes();
        System.out.println(mp.maxPalindromes("abaccdbbd", 3));
//        System.out.println(mp.maxPalindromes("fttfjofpnpfydwdwdnns", 2));
    }
}


