package com.eureka.test.algorithmsv2.bfs;

import com.eureka.test.factory.NodeTrans;

/**
 * <p>117. 填充每个节点的下一个右侧节点指针 II</p>
 * https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node-ii/
 *
 * @Author : Eric
 * @Date: 2021-07-12 17:09
 */
public class NodeConnnectTwo {
    public Node first = null, now = null;

    public Node connect(Node root) {
        if (root == null) {
            return root;
        }

        Node start = root;
        while (start != null) {
            for (Node s = start; s != null; s = s.next) {
                match(s.left);
                match(s.right);
            }
            start = first;
            now = null;
            first = null;
        }
        return root;
    }

    public void match(Node node) {
        if (now == null) {
            now = node;
        } else if (node != null) {
            now.next = node;
            now = node;
        }
        if (first == null) {
            first = node;
        }
        return;
    }

    public static void main(String[] args) {
        int[] s =
                {1, 2, 3, 4, 5, 6, 7};
        Node no = NodeTrans.transNode(s);
        NodeConnnectTwo n = new NodeConnnectTwo();

        System.out.println(n.connect(no));
    }
}
