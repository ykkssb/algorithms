package com.eureka.test.algorithmsv2.linkedlist;

import com.eureka.test.algorithms.container.ListNode;

/**
 * <p>1721. 交换链表中的节点</p>
 * https://leetcode-cn.com/problems/swapping-nodes-in-a-linked-list/
 *
 * @Author : Eric
 * @Date: 2021-01-22 23:48
 */
public class SwapNodes {

    // 1-2-3-4-5
    public ListNode swapNodes(ListNode head, int k) {
        ListNode s = head, f = head;

        ListNode l = null, r = null;
        int i = 0;
        while (i < k - 1) {
            i++;
            f = f.next;
        }
        l = f;
        while (f.next != null) {
            s = s.next;
            f = f.next;
        }
        r = s;
        if (l != r) {
            int tmp = l.val;
            l.val = r.val;
            r.val = tmp;
        }
        return head;

    }

    public static void main(String[] args) {
        ListNode l = new ListNode();
        l.val = 1;
        l.next = new ListNode(2);
        l.next.next = new ListNode(3);
        l.next.next.next = new ListNode(4);
        l.next.next.next.next = new ListNode(5);
        SwapNodes sn = new SwapNodes();

        System.out.println(sn.swapNodes(l, 2));
    }
}
