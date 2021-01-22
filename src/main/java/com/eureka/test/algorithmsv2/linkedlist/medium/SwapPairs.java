package com.eureka.test.algorithmsv2.linkedlist.medium;

import com.eureka.test.algorithms.container.ListNode;

import java.util.List;

/**
 * <p>24. 两两交换链表中的节点</p>
 * https://leetcode-cn.com/problems/swap-nodes-in-pairs/
 *
 * @Author : Eric
 * @Date: 2021-01-22 00:22
 */
public class SwapPairs {
    /**
     * todo 递归法
     *
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode node = head.next;
        head.next = swapPairs(node.next);
        node.next = head;
        return node;

    }

    /**
     * 非递归法
     * 0-1-2-3-4
     *
     * @param head
     * @return
     */
    public ListNode swapPairsTwo(ListNode head) {
        ListNode dum = new ListNode(0, head);
        ListNode cur = dum;
        while (cur.next != null && cur.next.next != null) {
            ListNode n1 = cur.next;
            ListNode n2 = cur.next.next;
            n1.next = n2.next;


            cur.next = n2;
            n2.next = n1;
            cur = n1;

        }

        return dum.next;
    }

    /**
     * 递归法
     * 1.next-> s(3->4)  3->null, 4->3; (1,2,3 | 4,3) ;1-4-3
     * <p>
     * 2.next 1
     *
     * @param args
     */
    public static void main(String[] args) {

        ListNode l = new ListNode();
        l.val = 1;
        l.next = new ListNode(2);
        l.next.next = new ListNode(3);
        l.next.next.next = new ListNode(4);

        SwapPairs s = new SwapPairs();
        System.out.println(s.swapPairsTwo(l));
    }
}
