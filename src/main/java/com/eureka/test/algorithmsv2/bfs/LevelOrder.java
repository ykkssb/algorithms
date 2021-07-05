package com.eureka.test.algorithmsv2.bfs;

import com.eureka.test.container.TreeNode;
import com.eureka.test.factory.TreeNodeTrans;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

/**
 * <p>102. 二叉树的层序遍历</p>
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 *
 * @Author : Eric
 * @Date: 2021-07-05 19:43
 */
public class LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(Arrays.asList(root.val));
        if (root.left == null && root.right == null) {
            return res;
        }
        List<TreeNode> list = new ArrayList<>();
        if (root.left != null) {
            list.add(root.left);
        }
        if (root.right != null) {
            list.add(root.right);
        }
        de(list, res);
        return res;
    }

    public List<List<Integer>> de(List<TreeNode> trees, List<List<Integer>> res) {
        if (trees.size() == 0) {
            return res;
        }

        List<Integer> list = new ArrayList<>();
        List<TreeNode> nTrees = new ArrayList<>();
        for (int i = 0; i < trees.size(); ++i) {
            TreeNode t = trees.get(i);
            if (t != null) {
                list.add(t.val);
                if (t.left != null) {
                    nTrees.add(t.left);
                }
                if (t.right != null) {
                    nTrees.add(t.right);
                }
            }
        }
        res.add(list);
        de(nTrees, res);
        return res;
    }

    public static void main(String[] args) {
        int[] array = {3,9,20,1000,1000,15,7};
        TreeNode t = TreeNodeTrans.transTreeNode(array);
        LevelOrder o = new LevelOrder();
        System.out.println(o.levelOrder(t));
    }
}