package com.eureka.test.algorithmsv2.linkedlist;

import com.eureka.test.algorithms.container.ListNode;

/**
 * <p>剑指 Offer 22. 链表中倒数第k个节点</p>
 * https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/
 *
 * @Author : Eric
 * @Date: 2021-01-19 23:41
 */
public class GetKthFromEnd {
    /**
     * 双指针|快慢指针思想间隔为k
     * 原指针没有破坏
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode s = head, f = head;
        while (k > 0) {
            f = f.next;
            k--;
        }
        while (f != null) {
            f = f.next;
            s = s.next;
        }
        return s;
    }

    public static void main(String[] args) {
        ListNode l = new ListNode();
        l.val = 1;
        l.next = new ListNode(2);
        l.next.next = new ListNode(3);
        l.next.next.next = new ListNode(4);
        l.next.next.next.next = new ListNode(5);

        GetKthFromEnd gd = new GetKthFromEnd();
        System.out.println(gd.getKthFromEnd(l, 2));
    }
}
