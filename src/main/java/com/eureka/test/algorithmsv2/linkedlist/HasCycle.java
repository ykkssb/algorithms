package com.eureka.test.algorithmsv2.linkedlist;

import com.eureka.test.algorithms.container.ListNode;

/**
 * <p>141. 环形链表</p>
 * https://leetcode-cn.com/problems/linked-list-cycle/
 *
 * @Author : Eric
 * @Date: 2021-01-21 20:50
 */
public class HasCycle {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode s = head, f = head;

        while (f.next != null && f.next.next != null) {
            s = s.next;
            f = f.next.next;
            if (s == f) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        HasCycle hc = new HasCycle();
        ListNode l = new ListNode();
        l.val = 1;
        l.next = new ListNode(2);
        System.out.println(hc.hasCycle(l));
    }
}
