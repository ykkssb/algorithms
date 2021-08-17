package com.eureka.test.algorithmsv2.array.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>90. 子集 II</p>
 * https://leetcode-cn.com/problems/subsets-ii/
 * https://leetcode-cn.com/problems/subsets-ii/solution/90-zi-ji-iiche-di-li-jie-zi-ji-wen-ti-ru-djmf/
 * @Author : Eric
 * @Date: 2021-08-08 14:40
 */
public class SubsetsWithDup {

    /**
     * todo v3
     * @param nums
     * @return
     */
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        boolean[] bo =new boolean[nums.length];
        bfs(nums, 0, bo);
        return res;
    }

    public void bfs(int [] nums, int start,   boolean[] bo) {
        if (start == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        bfs(nums, start + 1, bo);

        if (start > 0 && nums[start] == nums[start - 1] && !bo[start - 1]) {
            return;
        }

        bo[start] = true;
        list.add(nums[start]);

        bfs(nums, start + 1, bo);

        list.remove(list.size() - 1);
        bo[start] = false;
    }

        public static void main(String[] args) {
        SubsetsWithDup ss = new SubsetsWithDup();
        int[] n = {1, 2, 2};
//        System.out.println(ss.subsets(n));
//        System.out.println(ss.subsetsThree(n));
//        System.out.println(ss.subsetTwo(n));
        System.out.println(ss.subsetsWithDup(n));
    }

}
