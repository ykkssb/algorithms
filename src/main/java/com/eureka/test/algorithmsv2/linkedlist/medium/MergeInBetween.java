package com.eureka.test.algorithmsv2.linkedlist.medium;

import com.eureka.test.algorithms.container.ListNode;

/**
 * <p>1669. 合并两个链表</p>
 * https://leetcode-cn.com/problems/merge-in-between-linked-lists/
 *
 * @Author : Eric
 * @Date: 2021-01-21 21:20
 */
public class MergeInBetween {
    /**
     * 一次过
     *
     * @param list1
     * @param a
     * @param b
     * @param list2
     * @return
     */
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode l = new ListNode(0, list1);
        ListNode r = list2;
        int len = b - a + 1;
        // 0-0-1-2-3-4-5
        for (int i = 0; i < a; i++) {
            l = l.next;
        }
        ListNode t1 = l;
        for (int i = 0; i <= len; i++) {
            t1 = t1.next;
        }
        l.next = list2;

        while (r.next != null) {
            r = r.next;
        }
        r.next = t1;
        return list1;
    }

    /**
     * 4-3-2-1
     * 8-3-9-9
     * 27111
     * @param list1
     * @param list2
     * @return
     */
    public ListNode mergeInBetween(ListNode list1, ListNode list2) {
        ListNode l = reverse(list1);
        ListNode r = reverse(list2);
        ListNode res = new ListNode();
        ListNode n = res;
        int more = 0;
        while (l != null && r != null) {
            int v = l.val + r.val + more;
            if (v >= 10) {
                more = v / 10;
            }else{
                more = 0;
            }
            n.next = new ListNode(v % 10);
            l = l.next;
            r = r.next;
            n = n.next;
        }
        if(more!=0){
            n.next = new ListNode(more);
        }
        if(l!=null){
            n.next = l;
        }
        if(r!=null){
            n.next = r;
        }
        ListNode re = res.next;
        res.next = null;
        return reverse(re);
    }

    public ListNode reverse(ListNode head) {
        ListNode cur = null, pre = head;
        while (pre != null) {
            ListNode t = pre.next;
            pre.next = cur;
            cur = pre;
            pre = t;
        }
        return cur;
    }

    /**
     *   1234
     * + 9938
     * --------
     *  11172
     * @param args
     */
    public static void main(String[] args) {
        MergeInBetween m = new MergeInBetween();
        ListNode l = new ListNode(1);
        l.next = new ListNode(2);
        l.next.next = new ListNode(3);
        l.next.next.next = new ListNode(4);
        ListNode r = new ListNode(3);
        r.next = new ListNode(4);
//        r.next.next = new ListNode(3);
//        r.next.next.next = new ListNode(8);
        System.out.println(m.mergeInBetween(l, r));
    }
}