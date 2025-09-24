package com.eureka.test.algorithmsv2.treenode;

import com.eureka.test.container.TreeNode;
import com.eureka.test.factory.TreeNodeTrans;

import java.util.*;

/**
 * <p>二叉树的中序遍历</p>
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/submissions/
 *
 *      * 前序遍历 根 左 右
 *      * 中序遍历 左 根 右
 *      * 后序遍历 左 右 跟
 * @Author : Eric
 * @Date: 2020-07-01 20:03
 */
public class InorderTraversal {

    /**
     * todo v1
     * 递归法
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        bfs(res, root);
        return res;
    }

    public void bfs(List<Integer> res, TreeNode t) {
        if (t == null) {
            return;
        }
        bfs(res, t.left);
        res.add(t.val);
        bfs(res, t.right);
    }

    /**
     * 迭代算法
     * todo v3 -> v2 -> v1(250921) -v0(2509523)
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversalTw(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Deque<TreeNode> dq = new LinkedList<>();
        while (root != null || !dq.isEmpty()) {
            while (root != null) {
                dq.push(root);
                root = root.left;
            }
            TreeNode cur = dq.pop();
            ans.add(cur.val);
            if (cur.right != null) {
                root = cur.right;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode l1 = new TreeNode(2);
        TreeNode r1 = new TreeNode(3);
        l1.left = new TreeNode(4);
        l1.right = new TreeNode(5);
        r1.right = new TreeNode(6);
        root.left = l1;
        root.right = r1;
        int[] array = {1, 2, 3, 4, 5, 1000, 6};
        TreeNode t = TreeNodeTrans.transTreeNode(array);
        InorderTraversal in = new InorderTraversal();
        System.out.println(in.inorderTraversalTw(root));
        Deque<Integer> que = new LinkedList<>();
        que.push(1);
        que.push(2);
        que.push(3);
        System.out.println(que.poll());
    }
}
