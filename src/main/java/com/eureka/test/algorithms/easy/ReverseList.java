package com.eureka.test.algorithms.easy;

import com.eureka.test.algorithms.container.ListNode;

/**
 * <p>链表反转</p>
 * https://leetcode-cn.com/problems/reverse-linked-list/solution/dong-hua-yan-shi-206-fan-zhuan-lian-biao-by-user74/
 *
 * @Author : Eric
 * @Date: 2020-03-23 20:00
 */
public class ReverseList {

    // 1 - 4 - 2 -null
    public static ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = null;
        while (head != null) {
            cur = head.next;
            head.next = pre;
            pre = head;

            head = cur;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode n = new ListNode(1);

        n.next = new ListNode(4);
        n.next.next = new ListNode(2);
//        n.next.next.next = new ListNode(8);
//        n.next.next.next.next = new ListNode(6);
        System.out.println(reverseList(n));
    }
}
