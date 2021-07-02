package com.eureka.test.factory;

import com.eureka.test.container.TreeNode;

import java.util.TreeMap;

/**
 * <p></p>
 *
 * @Author : Eric
 * @Date: 2021-07-02 20:10
 */
public class Trans {

    public static TreeNode transTreeNode(int[] ss) {
        TreeNode res = new TreeNode(ss[0]);

        TreeNode tmp = res;
        for (int i = 1; i < ss.length; i += 2) {
            TreeNode l = null, r = null;
            tmp.left = l = isF(ss[i]) ? null : new TreeNode(ss[i]);
            tmp.right = r = isF(ss[i + 1]) ? null : new TreeNode(ss[i + 1]);
            tmp = l;
        }
        return res;
    }

    public static boolean isF(int i) {
        return i == 1000;
    }
}
