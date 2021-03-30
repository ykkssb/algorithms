package com.eureka.test.algorithmsv2.array;

/**
 * <p>1752. 检查数组是否经排序和轮转得到</p>
 * https://leetcode-cn.com/problems/check-if-array-is-sorted-and-rotated/
 * @Author : Eric
 * @Date: 2021-03-28 22:24
 */
public class Check {
    public boolean check(int[] nums) {
        int index=0;
        for(int i=1;i<nums.length;i++){
            if(nums[i]<nums[i-1]){
                index= i;
                break;
            }
        }
        if(index==0){
            return true;
        }
        for(int i=index+1;i< nums.length;i++){
            if(nums[i]<nums[i-1] ){
                return false;
            }
        }
        if(nums[nums.length-1]>nums[0]){
            return false;
        }
        return true;

    }



    public static void main(String[] args) {
        Check c = new Check();
        int[] n = {2,7,4,1,2,6,2};
        System.out.println(c.check(n));
    }
}
