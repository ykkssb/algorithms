package com.eureka.test.algorithms.hard;

import com.eureka.test.container.ListNode;

/**
 * <p>分隔链表</p>
 * https://leetcode-cn.com/problems/partition-list/
 * 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
 *
 * @Author : Eric
 * @Date: 2020-06-15 18:53
 */
public class PartitionListNode {

    public ListNode partition(ListNode head, int x) {
        ListNode bef = new ListNode(0);
        ListNode l = bef;
        ListNode aft = new ListNode(0);
        ListNode r = aft;

        while (head != null) {
            if (head.val < x) {
                l.next = new ListNode(head.val);
                l = l.next;
            } else {
                r.next = new ListNode(head.val);
                r = r.next;
            }

            head = head.next;
        }
        l.next = aft.next;

        return bef.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);
        l1.next.next.next = new ListNode(3);
        l1.next.next.next.next = new ListNode(2);
        l1.next.next.next.next.next = new ListNode(4);
        PartitionListNode d = new PartitionListNode();

        System.out.println(d.partition(l1, 3));
    }
}
