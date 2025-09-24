package com.eureka.test.algorithmsv2.treenode.medium;

import com.eureka.test.container.TreeNode;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.cn/problems/balance-a-binary-search-tree/description/
 * <p>
 * 将二叉搜索树变平衡
 *
 * @author : yujie.wang
 * @date: 2025-09-24 18:41
 */
public class BalanceBST {

    /**
     * 先用二叉树的中序遍历 放到 list
     * <p>
     * 在用 数组转换为二叉搜索树 思想组成 treeNode
     * <p>
     * notodo v0(250924）
     */
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> dq = new LinkedList<>();
        while (root != null || !dq.isEmpty()) {
            while (root != null) {
                dq.push(root);
                root = root.left;
            }
            TreeNode tmp = dq.pop();
            list.add(tmp.val);
            if (tmp.right != null) {
                root = tmp.right;
            }
        }
        return dfs(list, 0, list.size() - 1);
    }

    TreeNode dfs(List<Integer> list, int l, int r) {
        if (l > r) {
            return null;
        }
        int mid = l + r >> 1;
        TreeNode root = new TreeNode(list.get(mid));
        root.left = dfs(list, l, mid - 1);
        root.right = dfs(list, mid + 1, r);
        return root;
    }
}
