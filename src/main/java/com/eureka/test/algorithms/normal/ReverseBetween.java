package com.eureka.test.algorithms.normal;

import com.eureka.test.container.ListNode;

/**
 * <p>反转链表 II </p>
 * https://leetcode-cn.com/problems/reverse-linked-list-ii/
 *
 * @Author : Eric
 * @Date: 2020-06-28 17:16
 */
public class ReverseBetween {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        ListNode first_tmp = null;
        ListNode first = null;
        ListNode end = null;
        ListNode end_tmp = null;
        int index = 0;
        while (cur != null) {
            if (index == m - 1) {
                first = cur.next;
                first_tmp = cur;
            }
            if (index == n + 1) {
                end = cur;
                end_tmp = cur;
                break;
            }
            index++;
            cur = cur.next;
        }

        first_tmp.next = reverse(first, end, end_tmp);
        return dummy.next;
    }

    // 2,3,4  next 5
    public ListNode reverse(ListNode head, ListNode tail, ListNode next) {
        ListNode pre = next;
        ListNode cur = null;
        while (head != tail) {
            cur = head.next;
            head.next = pre;
            pre = head;
            head = cur;
        }
        return pre;
    }


    public static void main(String[] args) {
        ListNode n = new ListNode(1);
        n.next = new ListNode(2);
        n.next.next = new ListNode(3);
        n.next.next.next = new ListNode(4);
        n.next.next.next.next = new ListNode(5);
        n.next.next.next.next.next = new ListNode(6);
        ReverseBetween r = new ReverseBetween();
        System.out.println(r.reverseBetween(n, 2, 4));
    }

}
