package com.eureka.test.algorithms.container;

/**
 * <p></p>
 *
 * @Author : Eric
 * @Date: 2020-07-01 20:13
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(){}

    public TreeNode(int x) {
        val = x;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
