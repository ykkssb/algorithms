package com.eureka.test.algorithms.normal;

import com.eureka.test.algorithms.container.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * <p>二叉树的中序遍历</p>
 *
 * @Author : Eric
 * @Date: 2020-07-01 20:03
 */
public class InorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        TreeNode tmp = root;
        while (tmp != null || !st.isEmpty()) {

            while (tmp != null) {
                st.push(tmp);
                tmp = tmp.left;
            }

            tmp = st.pop();
            res.add(tmp.val);
            tmp = tmp.right;
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
        InorderTraversal in = new InorderTraversal();
        System.out.println(in.inorderTraversal(root));
    }
}
