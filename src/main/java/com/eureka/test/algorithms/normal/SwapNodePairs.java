package com.eureka.test.algorithms.normal;

import com.eureka.test.algorithms.container.ListNode;

/**
 * <p>两两交换节点</p>
 *
 * @Author : Eric
 * @Date: 2020-03-22 16:02
 */
public class SwapNodePairs {

    /**
     * 非递归解法
     *
     * @param head
     * @return
     */
    public static ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode tmp = dummy;
        while (tmp.next != null && tmp.next.next != null) {

            ListNode start = tmp.next;
            ListNode next = tmp.next.next;

            tmp.next = next;
            start.next = next.next;
            next.next = start;
            tmp = start;
        }
        return dummy.next;
    }

    /**
     * 递归法
     *
     * @param head
     * @return
     */
    public static ListNode swapPairsTwo(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        head.next = swapPairsTwo(next.next);
        next.next = head;
        return next;
    }


    public static void main(String[] args) {
        ListNode n = new ListNode(1);
        n.next = new ListNode(4);
        n.next.next = new ListNode(2);
        n.next.next.next = new ListNode(8);
        n.next.next.next.next = new ListNode(6);
        System.out.println(swapPairsTwo(n));

    }
}
