package com.eureka.test.algorithmsv2.treenode;

import com.eureka.test.container.TreeNode;

/**
 * https://leetcode.cn/problems/convert-sorted-array-to-binary-search-tree/
 * <p>
 * <p>
 * . 将有序数组转换为二叉搜索树
 *
 * @author : yujie.wang
 * @date: 2025-09-24 17:34
 */
public class SortedArrayToBST {

    /**
     * 整数数组 转 平衡 二叉搜索树(相当于中序排
     * todo v1(250924)
     */

    public TreeNode sortedArrayToBST(int[] nums) {

        return dfs(nums, 0, nums.length - 1);
    }

    TreeNode dfs(int[] nums, int l, int r) {
        if (l > r) {
            return null;
        }
        // 总是选择中间位置左边的数字作为根节点
//        int mid = (left + right) / 2;

        // 总是选择中间位置右边的数字作为根节点
        int mid = (l + r + 1) / 2;

        // 选择任意一个中间位置数字作为根节点
//        int mid = (left + right + rand.nextInt(2)) / 2;

        TreeNode root = new TreeNode(nums[mid]);
        root.left = dfs(nums, l, mid - 1);
        root.right = dfs(nums, mid + 1, r);
        return root;
    }

    public static void main(String[] args) {
        SortedArrayToBST sat = new SortedArrayToBST();
        int[] a = {-10, -3, 0, 5, 9};
        System.out.println(sat.sortedArrayToBST(a));
    }
}
