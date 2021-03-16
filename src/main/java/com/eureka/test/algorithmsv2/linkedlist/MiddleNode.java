package com.eureka.test.algorithmsv2.linkedlist;

import com.eureka.test.container.ListNode;

/**
 * <p>876. 链表的中间结点</p>
 *https://leetcode-cn.com/problems/middle-of-the-linked-list/
 * @Author : Eric
 * @Date: 2021-01-21 10:54
 */
public class MiddleNode {
    public ListNode middleNode(ListNode head) {
        ListNode s = head, f = head;
        while(f!=null && f.next!=null){
            s = s.next;
            f = f.next.next;
        }
        return s;

    }

    //1,2,3,4,5,6
    public static void main(String[] args) {
        ListNode l = new ListNode();
        l.val = 1;
        l.next = new ListNode(2);
        l.next.next = new ListNode(3);
        l.next.next.next = new ListNode(4);
        l.next.next.next.next = new ListNode(5);
        l.next.next.next.next.next = new ListNode(6);
        MiddleNode m = new MiddleNode();
        System.out.println(m.middleNode(l));

    }
}
