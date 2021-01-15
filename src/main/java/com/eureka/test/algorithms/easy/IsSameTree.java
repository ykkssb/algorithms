package com.eureka.test.algorithms.easy;

import com.eureka.test.algorithms.container.TreeNode;

/**
 * <p>是否相同的树</p>
 * https://leetcode-cn.com/problems/same-tree/
 *
 * @Author : Eric
 * @Date: 2020-07-29 20:22
 */
public class IsSameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {

        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        } else if (p.val != q.val) {
            return false;
        } else {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
    }

    public static void main(String[] args) {
        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(1);
        p.right = new TreeNode(2);
        TreeNode q = new TreeNode(1);
        q.left = new TreeNode(1);
        q.right  = new TreeNode(3);
        IsSameTree is = new IsSameTree();
        System.out.println(is.isSameTree(p, q));

    }

}
