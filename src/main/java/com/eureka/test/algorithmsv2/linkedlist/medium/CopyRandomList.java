package com.eureka.test.algorithmsv2.linkedlist.medium;

import com.eureka.test.algorithms.container.Node;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>剑指 Offer 35. 复杂链表的复制</p>
 * https://leetcode-cn.com/problems/fu-za-lian-biao-de-fu-zhi-lcof/
 *
 * @Author : Eric
 * @Date: 2021-01-21 21:40
 */
public class CopyRandomList {

    /**
     * todo 哈希表
     *
     * @param head
     * @return
     */
    public Node copyRandomList(Node head) {
        if(head==null){
            return head;
        }
        Map<Node, Node> map = new HashMap<>();
        Node cur = head;
        while (cur!=null) {
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }

        cur= head;
        while (cur!=null){
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }

    /**
     * 拼接+拆分
     *
     * @param head
     * @return
     */
    public Node copyRandomListTwo(Node head) {
        if (head == null) {
            return head;
        }
        Node cur = head;
        while (cur != null) {
            Node tmp = new Node(cur.val);
            tmp.next = cur.next;
            cur.next = tmp;
            cur = tmp.next;
        }
        cur = head;
        while (cur != null) {
            if (cur.random != null)
                cur.next.random = cur.random.next;
            cur = cur.next.next;
        }

        cur = head;
        Node pre = head.next, nex = head.next;
        while (cur.next.next != null) {
            cur.next = cur.next.next;
            pre.next = pre.next.next;
            pre = pre.next;
            cur = cur.next;

        }
        cur.next = null;
        return nex;
    }

    public static void main(String[] args) {
        CopyRandomList cr = new CopyRandomList();
        Node n = new Node(7);
        n.random = null;
        Node n2 = new Node(3);
        n.next = n2;
        n2.random = n;

        Node n3 = new Node(1);
        n2.next = n3;
        n3.random = n2;
        Node n4 = new Node(0);
        n3.next = n4;

        Node n5 = new Node(2);
        n4.next = n5;
        n4.random = n5;
        n5.random = n3;

        System.out.println(cr.copyRandomListTwo(n));

    }
}
