package com.eureka.test.algorithmsv2.linkedlist;

import com.eureka.test.container.ListNode;

/**
 * <p>面试题 02.07. 链表相交</p>
 * https://leetcode-cn.com/problems/intersection-of-two-linked-lists-lcci/
 *
 * @Author : Eric
 * @Date: 2021-01-21 21:06
 */
public class GetIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode l = headA, r = headB;
        while (l != r) {
            l = l != null ? l.next : headB;
            r = r!=null?r.next:headA;
        }
        return l;
    }

}
