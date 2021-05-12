package com.eureka.test.algorithmsv2.linkedlist.medium;

import com.eureka.test.container.ListNode;

/**
 * <p>24. 两两交换链表中的节点</p>
 * https://leetcode-cn.com/problems/swap-nodes-in-pairs/
 *
 * @Author : Eric
 * @Date: 2021-01-22 00:22
 */
public class SwapPairs {
    /**
     * todo v3递归法
     *
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next==null) {
            return null;
        }
        // 1-2-3-4

        ListNode next = head.next;
        head.next = swapPairs(next.next);
        next.next = head;
        return next;
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
        //0-1 -2-3 -4
        while (cur.next != null && cur.next.next != null) {
            ListNode l = cur.next;
            ListNode r = cur.next.next;
            cur.next = r;
            l.next = r.next;
            r.next = l;

            cur = l;

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
