package com.eureka.test.algorithmsv2.linkedlist;

import com.eureka.test.container.ListNode;

/**
 * <p>203. 移除链表元素</p>
 * https://leetcode-cn.com/problems/remove-linked-list-elements/
 *
 * @Author : Eric
 * @Date: 2021-01-21 20:28
 */
public class RemoveElements {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        // 哑节点
        ListNode cur = new ListNode(0,head);
        ListNode res= cur;
        // 1-2-6-3-4-5-6
        while (cur.next != null) {
            ListNode tmp = cur.next;

            if (tmp.val == val) {
                cur.next = tmp.next;
            } else {
                cur = cur.next;
            }
        }

        return res.next;
    }

    public static void main(String[] args) {
        RemoveElements r = new RemoveElements();
        ListNode l = new ListNode();
        l.val = 1;
        l.next = new ListNode(2);
        l.next.next = new ListNode(6);
        l.next.next.next = new ListNode(4);
        l.next.next.next.next = new ListNode(5);

        System.out.println(r.removeElements(l, 6));
    }
}
