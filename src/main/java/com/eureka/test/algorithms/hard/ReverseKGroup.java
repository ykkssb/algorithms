package com.eureka.test.algorithms.hard;

import com.eureka.test.algorithms.container.ListNode;

/**
 * <p>K个一组反转链表</p>
 * https://leetcode-cn.com/problems/reverse-nodes-in-k-group/
 *
 * @Author : Eric
 * @Date: 2020-03-23 18:53
 */
public class ReverseKGroup {


    /**
     * 1-4 - 3-5 - 7-9
     * <p>
     * tail : 3,5,7,9
     * 反转前 k 个元素 4,1 ,head = 1
     * </p>
     * 1-> reverseKGroup(3,5,7,9)
     * <p>
     * tail2 : 7,9
     * 5,3
     * 3 -> reverseKGroup(7,9)
     * </p>
     */
    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode tail = head;
        for (int i = 0; i < k; i++) {
            if (tail == null) {
                return head;
            }
            tail = tail.next;
        }

        ListNode newH = reverse(head, tail);
        head.next = reverseKGroup(tail, k);

        return newH;
    }

    public static ListNode reverse(ListNode head, ListNode tail) {
        ListNode pre = null;
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
//        ListNode n2 = new ListNode(2);

        n.next = new ListNode(4);
        n.next.next = new ListNode(3);
        n.next.next.next = new ListNode(5);
        n.next.next.next.next = new ListNode(7);
        n.next.next.next.next.next = new ListNode(9);
        System.out.println(reverseKGroup(n, 2));
    }
}
