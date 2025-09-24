package com.eureka.test.algorithmsv2.treenode.medium;

import com.eureka.test.container.TreeNode;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.cn/problems/create-binary-tree-from-descriptions/
 * <p>
 * 根据描述创建二叉树
 *
 * @author : yujie.wang
 * @date: 2025-09-24 19:08
 */
public class CreateBinaryTree {


    /**
     * v0（250924）
     *
     * @param desc
     * @return
     */
    public TreeNode createBinaryTree(int[][] desc) {
        int k = desc.length;
        TreeNode ans = null;
        Set<Integer> has = new HashSet<>();
        for (int i = 0; i < k; i++) {
            int[] a = desc[i];
            has.add(a[1]);
        }
        Map<Integer, TreeNode> map = new HashMap<>();
        for (int i = 0; i < k; i++) {
            int[] a = desc[i];
            TreeNode p = getMap(map, a[0]);
            map.put(p.val, p);
            if (!has.contains(p.val)) {
                ans = p;
            }

            boolean left = a[2] == 1 ? true : false;
            TreeNode c = getMap(map, a[1]);
            map.put(c.val, c);

            if (left) {
                p.left = c;
            } else {
                p.right = c;
            }

        }
        return ans;
    }

    public TreeNode getMap(Map<Integer, TreeNode> map, int v) {
        if (map.containsKey(v)) {
            return map.get(v);
        } else {
            return new TreeNode(v);
        }
    }
}
