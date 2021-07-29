package com.eureka.test.algorithmsv2.array;

/**
 * <p>二分查找</p>
 * https://leetcode-cn.com/problems/binary-search/submissions/
 *
 * @Author : Eric
 * @Date: 2021-03-23 22:16
 */
public class HalfSearch {
    /**
     * 1. 为什么 while 循环的条件中是 <=，而不是 < ？
     * <p>
     * 答：因为初始化 right 的赋值是 nums.length - 1，即最后一个元素的索引，而不是 nums.length。
     * 2. 为什么 left = mid + 1，right = mid - 1？我看有的代码是 right = mid 或者 left = mid，没有这些加加减减，到底怎么回事，怎么判断？
     * <p>
     * 答：这也是二分查找的一个难点，不过只要你能理解前面的内容，就能够很容易判断。
     * <p>
     * 刚才明确了「搜索区间」这个概念，而且本算法的搜索区间是两端都闭的，即 [left, right]。那么当我们发现索引 mid 不是要找的 target 时，如何确定下一步的搜索区间呢？
     * <p>
     * 当然是去搜索 [left, mid - 1] 或者 [mid + 1, right] 对不对？因为 mid 已经搜索过，应该从搜索区间中去除。
     *
     * @param nums
     * @param target
     * @return
     */
    public int halfSearch(int[] nums, int target) {
        int l =0, r= nums.length-1;
        while(l<=r){
            int mid = (l+r)/2;
            if(nums[mid]==target){
                return mid;
            }else if(nums[mid]>target){
                r= mid-1;
            }else if(nums[mid]<target){
                l = mid+1;
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        HalfSearch h = new HalfSearch();
        int[] con = {1, 2, 2, 2,2,2,2, 4};
        System.out.println(h.halfSearch(con, 2));
    }
}
