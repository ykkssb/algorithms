package com.eureka.test.algorithmsv2.string.normal;

import java.util.*;

/**
 * <p>893. 特殊等价字符串组 medium</p>
 * https://leetcode-cn.com/problems/groups-of-special-equivalent-strings/
 *
 * @Author : Eric
 * @Date: 2021-01-27 17:47
 */
public class NumSpecialEquivGroups {

    /**
     * todo v4 等价类的数量(素数乘积构造唯一性)
     * 抽象代数的知识 等价关系与划分 实质是求等价类的数量 关键在于如何找到函数C使得C(S) = C(T) 最难的一环就解决了
         * 可以用素数乘积构造唯一性 也可以用字符串排序构造等等 而最可贵的 就是这种化一的思想 找共性的思想 找不同大家都一样能看出的
     * 但深层次的共性却很难一下发现 而抽象代数中最可贵的就是 对事物共性的发掘
     * xyzz zzxy
     *
     * @return
     */
    public int numSpecialEquivGroups(String[] words) {
        int len =words[0].length();
        Set<String> set =  new HashSet<>();
        for(String s:words){
            int[] bit = new int[52];
            for(int i=0;i<len; ++i){
                int incr  = i%2==0? 0: 26;
                bit[s.charAt(i)-'a' + incr]++;
            }

            set.add(Arrays.toString(bit));

        }
        return set.size();
    }

    public static void main(String[] args) {
        NumSpecialEquivGroups ns = new NumSpecialEquivGroups();
        String[] a = {"abcd", "cdab", "cbad", "xyzz", "zzxy", "zzyx"};
        System.out.println(ns.numSpecialEquivGroups(a));
        Map<String, Integer> map = new HashMap<>();
        map.put(String.valueOf('c'), 1);
        String res = "1-";
        res = res.substring(0, res.length()-1);
                System.out.println(res);

    }

}
