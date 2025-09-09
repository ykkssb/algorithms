package com.eureka.test.algorithmsv2.treenode;

import com.eureka.test.container.TreeNode;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/construct-binary-tree-from-inorder-and-postorder-traversal/description/?envType=problem-list-v2&envId=hash-table
 * todo 难难难
 * 106. 从中序与后序遍历序列构造二叉树
 *
 * @author : yujie.wang
 * @date: 2025-09-09 19:28
 */
public class BuildTreeRight {

    Map<Integer, Integer> map = new HashMap<>();
    int[] post;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        for (int i = 0; i < n; i++) {
            map.put(inorder[i], i);
        }
        post = postorder;
        return buildCenter(0, n - 1, 0, n - 1);
    }

    public TreeNode buildCenter(int il, int ir, int pl, int pr) {
        if (il > ir || pl > pr) {
            return null;
        }
        int first = post[pr];
        int midIndex = map.get(first);
        TreeNode root = new TreeNode(first);
        root.left = buildCenter(il, midIndex - 1, pl, pl + midIndex - il - 1);
        root.right = buildCenter(midIndex + 1, ir, pl + midIndex - il, pr - 1);
        return root;
    }

    public static void main(String[] args) {
        BuildTreeLeft bt = new BuildTreeLeft();
        int[] a = {9, 3, 15, 20, 7};
        int[] b = {9,15, 7 ,20 , 3};
        System.out.println(bt.buildTree(a,b));
    }
}