package com.eureka.test.algorithms.easy;

import com.eureka.test.algorithms.normal.AddTwoNumber;

/**
 * <p>合并两个有序链表</p>
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/
 *
 * @Author : Eric
 * @Date: 2020-03-20 19:50
 */
public class MergeTwoLists {

    public static class ListNode {
        int val;

        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode preHead = new ListNode(-1);
        ListNode prev = preHead;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }

        prev.next = l1 != null ? l1 : l2;
        return preHead.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(2);
        l2.next.next = new ListNode(3);
        System.out.println(mergeTwoLists(l1, l2));
    }
}
