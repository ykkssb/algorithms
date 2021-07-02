package com.eureka.test.algorithmsv2.bfs;

import com.eureka.test.container.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

/**
 * <p>101. 对称二叉树</p>
 * https://leetcode-cn.com/problems/symmetric-tree/
 *
 * @Author : Eric
 * @Date: 2021-07-02 19:41
 */
public class IsSymmetric {
    /**
     * 方法一：递归
     *
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        return check(root.left, root.right);
    }

    public boolean same(TreeNode l, TreeNode r) {
        if (l == null && r == null) {

            return true;
        } else if (l == null || r == null) {
            return false;
        } else if (l.val != r.val) {
            return false;
        }
        return same(l.left, r.right) && same(l.right, r.left);
    }

    /**
     * 方法二：迭代
     *
     * @param l
     * @param r
     * @return
     */
    public boolean check(TreeNode l, TreeNode r) {
        if (l == null && r == null) {
            return true;
        }
        Queue<TreeNode> p = new LinkedList<>();
        Queue<TreeNode> q = new LinkedList<>();
        p.offer(l);
        q.offer(r);
        while (!p.isEmpty() && !q.isEmpty()) {

            TreeNode t = p.poll();
            TreeNode y = q.poll();
            if (t == null ^ y == null) {
                return false;
            }

            if (t != null && t.val != y.val) {
                return false;
            }
            TreeNode l1 = t.left, r1 = t.right, l2 = y.left, r2 = y.right;
            if (l1 == null ^ r2 == null) {
                return false;
            }
            if (r1 == null ^ l2 == null) {
                return false;
            }
            if (l1 != null) {
                p.offer(l1);
                q.offer(r2);
            }
            if (r1 != null) {
                p.offer(r1);
                q.offer(l2);

            }
        }
        return p.isEmpty() && q.isEmpty();
    }

    public static void main(String[] args) {
        TreeNode p = new TreeNode(2);
//        p.left = new TreeNode(3);
        p.right = new TreeNode(4);
        TreeNode q = new TreeNode(2);
        q.left = new TreeNode(4);
        q.right = new TreeNode(3);
        TreeNode r = new TreeNode(1);
        r.left = p;
        r.right = q;
//        int[] rs = {1, 0, 1, 0, 1,10000};
        IsSymmetric is = new IsSymmetric();
        System.out.println(is.isSymmetric(r));

    }

}
