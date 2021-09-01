package com.eureka.test.algorithmsv2.treenode;

import com.eureka.test.container.TreeNode;

import java.util.*;

/**
 * <p>145. 二叉树的后序遍历</p>
 * https://leetcode-cn.com/problems/binary-tree-postorder-traversal/
 * https://leetcode-cn.com/problems/binary-tree-postorder-traversal/solution/bang-ni-dui-er-cha-shu-bu-zai-mi-mang-che-di-chi-t/
 *
 * @Author : Eric
 * @Date: 2021-08-03 23:35
 */
public class PostorderTraversal {
    /**
     * todo v3 -> v4
     *
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> de = new LinkedList<>();
        TreeNode pre = null;
        while (root != null || !de.isEmpty()) {
            while (root != null) {
                de.push(root);
                root = root.left;
            }
            root = de.poll();
            if (root.right == null || root.right == pre) {
                res.add(root.val);
                pre = root;
                root = null;

            } else {
                de.push(root);
                root = root.right;
            }
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
        PostorderTraversal p = new PostorderTraversal();
        System.out.println(p.postorderTraversal(root));
    }
}
