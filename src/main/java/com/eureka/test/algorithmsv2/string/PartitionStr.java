package com.eureka.test.algorithmsv2.string;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/palindrome-partitioning/
 * 131. 分割回文串
 * @author : yujie.wang
 * @date: 2025-09-01 17:41
 */
public class PartitionStr {

    List<List<String>> ans = new ArrayList<>();
    boolean[][] b;
    int n;
    public List<List<String>> partition(String s) {
        n = s.length();
        b = new boolean[n][n];
        for(int i=n-1;i>=0;i--){
            b[i][i] = true;
            for(int j=i+1 ; j<n; j++){
                if(s.charAt(i)==s.charAt(j)){
                    if(j == i+1){
                        b[i][j] = true;
                    }else{
                        b[i][j] = b[i+1][j-1];
                    }
                }
            }
        }
        dfs(s, 0 ,new ArrayList());
        return ans;

    }

    void dfs(String s, int i, List<String> list){
        if(i>=n){
            ans.add(new ArrayList(list));
            return;
        }
        for(int j=i; j<n ;j++){
            if(b[i][j]){
                list.add(s.substring(i,j+1));
                dfs(s, j+1, list );
                list.remove(list.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        String s = "aab";

        PartitionStr p = new PartitionStr();
        System.out.println(p.partition(s));
    }
}
