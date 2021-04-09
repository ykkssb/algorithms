package com.eureka.test.algorithmsv2.string;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>1624. 两个相同字符之间的最长子字符串</p>
 * https://leetcode-cn.com/problems/largest-substring-between-two-equal-characters/
 *
 * @Author : Eric
 * @Date: 2021-01-28 17:36
 */
public class MaxLengthBetweenEqualCharacters {
    public int maxLengthBetweenEqualCharacters(String s) {
        int res = -1;
        Map<Character,Integer> map = new HashMap<>();
        for(int i=0;i<s.length();++i){
            if(!map.containsKey(s.charAt(i))){
                map.put(s.charAt(i),i);
            }else{
                res= Math.max(res,  i-1-map.get(s.charAt(i)));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        MaxLengthBetweenEqualCharacters m = new MaxLengthBetweenEqualCharacters();
        System.out.println(m.maxLengthBetweenEqualCharacters("ba"));
    }
}
