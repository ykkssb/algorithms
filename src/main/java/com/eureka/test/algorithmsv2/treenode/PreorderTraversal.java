package com.eureka.test.algorithmsv2.treenode;

import com.eureka.test.container.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * <p>144. 二叉树的前序遍历
 * https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
 * <p>
 * 615</p>
 *
 * @Author : Eric
 * @Date: 2021-08-03 22:46
 */
public class PreorderTraversal {
    /**
     * todo v3
     *
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> de = new LinkedList<>();
        while (root != null || !de.isEmpty()) {
            while (root != null) {
                res.add(root.val);
                de.push(root);
                root = root.left;
            }
            root = de.pop();
            root = root.right;
        }
        return res;

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
        PreorderTraversal p = new PreorderTraversal();
        System.out.println(p.preorderTraversal(root));
    }
}
