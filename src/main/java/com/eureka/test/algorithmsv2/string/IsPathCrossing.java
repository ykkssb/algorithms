package com.eureka.test.algorithmsv2.string;

import java.util.HashSet;
import java.util.Set;

/**
 * <p>1496. 判断路径是否相交</p>
 * https://leetcode-cn.com/problems/path-crossing/
 *
 * @Author : Eric
 * @Date: 2021-02-28 13:37
 */
public class IsPathCrossing {
    /**
     * todo v2
     *
     * @param path
     * @return
     */
    public boolean isPathCrossing(String path) {
       Set<String> set = new HashSet<>();
       set.add("0-0");
       int l =0,r=0;
       for(char c :path.toCharArray()){
           if(c=='N'){
               l++;
           }else if(c=='S'){
               l--;
           }else if(c=='E'){
               r++;
           }else{
               r--;
           }
           if(set.contains(l+"-"+r)){
               return true;
           }else{
               set.add(l + "-" + r);
           }
       }
        return false;
    }

    public static void main(String[] args) {
        IsPathCrossing is = new IsPathCrossing();
        System.out.println(is.isPathCrossing("NESWW"));

    }
}
