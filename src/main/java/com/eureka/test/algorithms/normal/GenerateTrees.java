package com.eureka.test.algorithms.normal;

import com.eureka.test.container.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * <p>95. 不同的二叉搜索树 II</p>
 * https://leetcode-cn.com/problems/unique-binary-search-trees-ii/solution/95-bu-tong-de-er-cha-sou-suo-shu-ii-by-ming-zhi-sh/
 *
 * @Author : Eric
 * @Date: 2020-07-07 20:11
 */
public class GenerateTrees {

    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new LinkedList<TreeNode>();
        }

        return generate(1, n);
    }

    public LinkedList<TreeNode> generate(int start, int end) {
        LinkedList<TreeNode> res = new LinkedList<TreeNode>();
        if (start > end) {
            res.add(null);
            return res;
        }

        for (int i = start; i <= end; i++) {
            LinkedList<TreeNode> left = generate(start, i - 1);
            LinkedList<TreeNode> right = generate(i + 1, end);

            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    TreeNode t = new TreeNode(i);
                    t.left = l;
                    t.right = r;
                    res.add(t);
                }
            }
        }
        return res;

    }

    public static void main(String[] args) {
        GenerateTrees gt = new GenerateTrees();
        System.out.println(gt.generateTrees(3));
    }
}
