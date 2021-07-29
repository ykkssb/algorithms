package com.eureka.test.algorithmsv2.bfs;

import com.eureka.test.factory.NodeTrans;
import org.w3c.dom.traversal.NodeFilter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 * 116. 填充每个节点的下一个右侧节点指针</p>
 * https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node/
 *
 * @Author : Eric
 * @Date: 2021-07-12 16:56
 */
public class NodeConnect {
    List<List<Node>> res = new ArrayList<>();

    /**
     * 方法一
     *
     * @param root
     * @return
     */
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        res.add(Arrays.asList(root));
        List<Node> list = new ArrayList<>();
        if (root.left != null) {
            list.add(root.left);
        }
        if (root.right != null) {
            list.add(root.right);
        }
        res.add(list);
        next(list);
        for (int i = 0; i < res.size(); ++i) {
            List<Node> nodes = res.get(i);
            for (int j = nodes.size() - 2; j >= 0; j--) {
                nodes.get(j).next = nodes.get(j + 1);
            }
        }
        return root;
    }

    public void next(List<Node> list) {
        if (list.size() == 0) {
            return;
        }
        List<Node> nList = new ArrayList<>();
        for (int i = 0; i < list.size(); ++i) {
            Node t = list.get(i);
            if (t.left != null) {
                nList.add(t.left);
            }
            if (t.right != null) {
                nList.add(t.right);
            }
        }
        res.add(nList);
        next(nList);
        return;
    }

    /**
     * 你只能使用常量级额外空间
     */
    public Node connectTw(Node root) {
        if (root == null) {
            return root;
        }
        next(root);
        return root;
    }

    private void next(Node t) {
        if (t.left == null) {
            return;
        }
        t.left.next = t.right;
        if (t.next != null) {
            t.right.next = t.next.left;
        }
        next(t.left);
        next(t.right);

    }

    public static void main(String[] args) {
        int[] s =
                {1, 2, 3, 4, 5, 6, 7};
        Node no = NodeTrans.transNode(s);
        NodeConnect n = new NodeConnect();

        System.out.println(n.connectTw(no));
    }
}
