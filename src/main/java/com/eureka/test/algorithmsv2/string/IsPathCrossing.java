package com.eureka.test.algorithmsv2.string;

import java.util.HashSet;
import java.util.Set;

/**
 * <p>1496. 判断路径是否相交</p>
 * https://leetcode-cn.com/problems/path-crossing/
 * @Author : Eric
 * @Date: 2021-02-28 13:37
 */
public class IsPathCrossing {
    public boolean isPathCrossing(String path) {
        Set<Integer> set = new HashSet<>();
        char[] ch = path.toCharArray();

        int l =0 ,r =0;
        set.add((l+10000)<<16|(r+10000));
        for(char c:ch){
            if(c=='N'){
                l++;
            }else if(c=='S'){
                l--;
            }else if(c=='E'){
                r++;
            }else if(c=='W'){
                r--;
            }
            Integer s = (l+10000)<<16|(r+10000);
            if(set.contains(s)){
                return true;
            }else{
                set.add(s);
            }
        }

        return false;
    }

    public static void main(String[] args) {
        IsPathCrossing is = new IsPathCrossing();
        System.out.println(is.isPathCrossing("WSSESEEE"));

    }
}
