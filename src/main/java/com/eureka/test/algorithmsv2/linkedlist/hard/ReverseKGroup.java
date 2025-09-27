package com.eureka.test.algorithmsv2.linkedlist.hard;

import com.eureka.test.container.ListNode;

/**
 * @author : yujie.wang
 * @date: 2025-09-25 19:52
 */
public class ReverseKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {

        if (k == 1) {
            return head;
        }

        ListNode dummy = new ListNode(0, head);
        ListNode t = head, d = dummy;
        boolean more = true;
        while (t != null && more) {
            ListNode end = t;
            for (int i = 0; i < k - 1; i++) {
                if (end.next == null) {
                    more = false;
                } else {
                    end = end.next;
                }
            }
            if (!more) {
                d.next = t;
                return dummy.next;
            }
            ListNode next = end.next;
            end.next = null;

            ListNode start = t;
            d.next = rev(start);
            d = t;
            t = next;
        }
        return dummy.next;
    }

    ListNode rev(ListNode head) {
        ListNode pre = head, cur = null;
        while (pre != null) {
            ListNode tmp = pre.next;
            pre.next = cur;
            cur = pre;
            pre = tmp;
        }
        return cur;
    }
}
