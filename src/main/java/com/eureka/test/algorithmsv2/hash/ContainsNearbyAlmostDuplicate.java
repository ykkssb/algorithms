package com.eureka.test.algorithmsv2.hash;

import java.util.HashMap;
import java.util.Map;

/**
 *
 220. 存在重复元素 III
 https://leetcode.cn/problems/contains-duplicate-iii/description/
  todo
* @author : yujie.wang
* @date: 2025-09-08 17:37
*/
public class ContainsNearbyAlmostDuplicate {

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            int w = t+1;
            int id = getId(nums[i], w);
            if(map.containsKey(id)){
                return true;
            }
            if(map.containsKey(id-1) && Math.abs(nums[i]-map.get(id-1))<w){
                return true;
            }
            if(map.containsKey(id+1) && Math.abs(nums[i]-map.get(id+1))<w){
                return true;
            }
            map.put(id ,nums[i]);

            // 必须>=
            if(i>=k){
                map.remove(getId(nums[i-k],w));
            }
        }
        return false;
    }

    int getId(int s, int w){
        return (s+1000000000) /w;
    }


    public static void main(String[] args) {
        ContainsNearbyAlmostDuplicate c = new ContainsNearbyAlmostDuplicate();
        int[] a = {1,5,9,1,5,9};
        System.out.println(c.containsNearbyAlmostDuplicate(a, 2,3));
    }
}
