package com.eureka.test.algorithmsv2.linkedlist.medium;

import com.eureka.test.algorithms.container.ListNode;

/**
 * <p>147. 对链表进行插入排序</p>
 * https://leetcode-cn.com/problems/insertion-sort-list/
 *
 * @Author : Eric
 * @Date: 2021-01-23 00:04
 */
public class InsertionSortList {

    /**
     * todo 插入排序思想
     * -1- 5- 3-4 -0
     *
     * @param head
     * @return
     */
    public ListNode insertionSortList(ListNode head) {

        // n-4 2 1 3
        ListNode dum = new ListNode(0, head);
        ListNode pre = dum.next, cur = head.next;
        while (cur != null) {
            if (pre.val <= cur.val) {
                pre = pre.next;
            } else {
                ListNode p = dum;
                // im
                while (p.next.val <= cur.val) {
                    p = p.next;
                }
                pre.next = cur.next;
                cur.next = p.next;
                p.next = cur;
            }
            cur = pre.next;
        }
        return dum.next;

    }

    public static void main(String[] args) {
        ListNode l = new ListNode();
        l.val = -1;
        l.next = new ListNode(5);
        l.next.next = new ListNode(3);
        l.next.next.next = new ListNode(4);
        l.next.next.next.next = new ListNode(0);
        InsertionSortList ii = new InsertionSortList();
        System.out.println(ii.insertionSortList(l));
    }
}
