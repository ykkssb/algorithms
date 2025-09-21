package com.eureka.test.algorithmsv2.linkedlist.medium;

import com.eureka.test.container.TreeNode;

/**
 * https://leetcode.cn/problems/flatten-binary-tree-to-linked-list/?envType=problem-list-v2&envId=linked-list
 * <p>
 * 二叉树展开为链表
 *
 * @author : yujie.wang
 * @date: 2025-09-21 19:14
 */
public class Flatten {

    /**
     * 方法三：寻找前驱节点
     * 展开后的单链表应该与二叉树 先序遍历 顺序相同。 先序遍历 根左右
     *
     * @param root
     */
    public void flatten(TreeNode root) {
        TreeNode cur = root;

        while (cur != null) {
            if (cur.left != null) {
                TreeNode next = cur.left;
                TreeNode pre = next;
                while (pre.right != null) {
                    pre = pre.right;
                }
                pre.right = cur.right;
                cur.left = null;
                cur.right = next;
            }
            cur = cur.right;
        }

    }
}
