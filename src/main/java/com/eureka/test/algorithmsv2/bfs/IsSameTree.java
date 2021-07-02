package com.eureka.test.algorithmsv2.bfs;

import com.eureka.test.container.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

/**
 * <p>是否相同的树</p>
 * https://leetcode-cn.com/problems/same-tree/
 *
 * @Author : Eric
 * @Date: 2020-07-29 20:22
 */
public class IsSameTree {

    /**
     * 方法一：深度优先搜索
     *
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    /**
     * 方法二：广度优先搜索
     *
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTreeTw(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        }

        Queue<TreeNode> pq = new LinkedList<TreeNode>();
        Queue<TreeNode> qq = new LinkedList<TreeNode>();
        pq.offer(p);
        qq.offer(q);
        while (!pq.isEmpty() && !qq.isEmpty()) {
            TreeNode t1 = pq.poll();
            TreeNode t2 = qq.poll();
            if (t1.val != t2.val) {
                return false;
            }
            TreeNode l1 = t1.left, l2 = t2.left, r1 = t1.right, r2 = t2.right;
            if (l1 == null ^ l2 == null) {
                return false;
            }
            if (r1 == null ^ r2 == null) {
                return false;
            }
            if (l1 != null) {
                pq.offer(l1);
            }
            if (l2 != null) {
                qq.offer(l2);
            }
            if (r1 != null) {
                pq.offer(r1);
            }
            if (r2 != null) {
                qq.offer(r2);
            }
        }
        return pq.isEmpty() && qq.isEmpty();
    }

    public static void main(String[] args) {
        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(1);
        p.right = new TreeNode(3);
        TreeNode q = new TreeNode(1);
        q.left = new TreeNode(1);
        q.right = new TreeNode(3);
        IsSameTree is = new IsSameTree();
        System.out.println(is.isSameTreeTw(p, q));

    }

}
