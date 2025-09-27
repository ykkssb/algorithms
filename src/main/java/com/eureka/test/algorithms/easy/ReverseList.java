package com.eureka.test.algorithms.easy;

import com.eureka.test.container.ListNode;
import java.util.List;

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
        ListNode pre = head;
        ListNode cur= null;
        while(pre!=null){
            ListNode tmp = pre.next;
            pre.next = cur;
            cur = pre;
            pre = tmp;
        }
        return cur;
    }

    public static void main(String[] args) {
        ListNode n = new ListNode(1);

        n.next = new ListNode(4);
        n.next.next = new ListNode(2);
//        n.next.next.next = new ListNode(8);
//        n.next.next.next.next = new ListNode(6);

        ListNode listNode = reverseList(n);
        System.out.println(listNode);
        System.out.println(n);
        System.out.println("1");
    }
}
