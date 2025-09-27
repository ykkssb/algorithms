package com.eureka.test.algorithmsv2.bfs;

import com.eureka.test.factory.NodeTrans;
import java.util.Deque;
import java.util.LinkedList;
import org.w3c.dom.traversal.NodeFilter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 * 116. 填充每个节点的下一个右侧节点指针</p> https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node/
 *
 * @Author : Eric
 * @Date: 2021-07-12 16:56
 */
public class NodeConnect {

    List<List<Node>> res = new ArrayList<>();


    /**
     * 时间复杂度： O(n)
     * <p>
     * 空间复杂度： O(1)
     */
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        Node pre = root;
        while (pre.left != null) {
            Node tmp = pre;
            while (tmp != null) {
                tmp.left.next = tmp.right;
                if (tmp.next != null) {
                    tmp.right.next = tmp.next.left;
                }
                tmp = tmp.next;
            }
            pre = pre.left;
        }
        return root;
    }


    /**
     * 时间复杂度： O(n)
     * <p>
     * 空间复杂度： O(n)
     */
    public Node connectTw(Node root) {
        if (root == null) {
            return root;
        }
        root.next = null;
        LinkedList<Node> dq = new LinkedList<>();
        dq.add(root);
        dfs(dq);
        return root;
    }

    void dfs(LinkedList<Node> dq) {
        while (!dq.isEmpty()) {
            int size = dq.size();
            Node tmp = dq.get(0);
            for (int i = 1; i < size; i++) {
                tmp.next = dq.get(i);
                tmp = dq.get(i);
            }
            for (int i = 0; i < size; i++) {
                Node t = dq.remove();
                if (t.left != null) {
                    dq.add(t.left);
                    dq.add(t.right);
                }
            }

        }
    }

    public static void main(String[] args) {
        int[] s =
            {-1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 12};
        Node no = NodeTrans.transNode(s);
        NodeConnect n = new NodeConnect();

        System.out.println(n.connectTw(no));
    }
}
