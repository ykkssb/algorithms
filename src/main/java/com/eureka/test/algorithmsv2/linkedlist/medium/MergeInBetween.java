package com.eureka.test.algorithmsv2.linkedlist.medium;

import com.eureka.test.algorithms.container.ListNode;

/**
 * <p>1669. 合并两个链表</p>
 * https://leetcode-cn.com/problems/merge-in-between-linked-lists/
 *
 * @Author : Eric
 * @Date: 2021-01-21 21:20
 */
public class MergeInBetween {
    /**
     * 一次过
     *
     * @param list1
     * @param a
     * @param b
     * @param list2
     * @return
     */
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode l = new ListNode(0, list1);
        ListNode r = list2;
        int len = b - a + 1;
        // 0-0-1-2-3-4-5
        for (int i = 0; i < a; i++) {
            l = l.next;
        }
        ListNode t1 = l;
        for (int i = 0; i <= len; i++) {
            t1 = t1.next;
        }
        l.next = list2;

        while (r.next != null) {
            r = r.next;
        }
        r.next = t1;
        return list1;
    }
}