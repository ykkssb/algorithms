package com.eureka.test.algorithmsv2.linkedlist.medium;

import com.eureka.test.algorithms.container.ListNode;

/**
 * <p>148. 排序链表</p>
 * https://leetcode-cn.com/problems/sort-list/
 * https://leetcode-cn.com/problems/sort-list/solution/pai-xu-lian-biao-di-gui-die-dai-xiang-jie-by-cherr/
 *
 * @Author : Eric
 * @Date: 2021-01-25 10:23
 */
public class SortList {

    /**
     * 1、递归法
     * 插入排序的时间复杂度是 O(n^2)，其中 n 是链表的长度。这道题考虑时间复杂度更低的排序算法。
     * 题目的进阶问题要求达到 O(nlogn) 的时间复杂度和 O(1) 的空间复杂度，
     * 时间复杂度是O(nlogn) 的排序算法包括归并排序、堆排序和快速排序（快速排序的最差时间复杂度是 O(n^2)其中最适合链表的排序算法是归并排序。
     * 所以不推荐插入排序
     * 1-2-3-4-5
     *
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode next = slow.next;
        slow.next = null;
        ListNode l = sortList(head);
        ListNode r = sortList(next);
        return merge(l, r);
    }


    /**
     * todo 归并排序
     * 方法2、迭代法
     * 4 3   2 6    5 7   1
     *
     * @param head
     */
    public ListNode sortListTwo(ListNode head) {
        ListNode dum = new ListNode(0, head);
        int len = getLength(head);
        for (int i = 1; i < len; i <<= 1) {
            ListNode pre = dum;
            ListNode cur = dum.next;
            while (cur != null) {
                ListNode l1 = cur;
                ListNode l2 = split(cur, i);
                cur = split(l2, i);
                ListNode mg = merge(l1, l2);
                pre.next = mg;
                while (pre.next != null) {
                    pre = pre.next;
                }
            }
        }
        return dum.next;
    }

    public int getLength(ListNode head) {
        ListNode cur = head;
        int len = 0;
        while (cur != null) {
            len++;
            cur = cur.next;
        }
        return len;
    }

    public ListNode split(ListNode head, int len) {
        if (head == null) {
            return head;
        }
        ListNode cur = head;
        int n = 1;
        while (n < len && cur.next != null) {
            n++;
            cur = cur.next;
        }
        ListNode next = cur.next;
        cur.next = null;
        return next;
    }

    public ListNode merge(ListNode l, ListNode r) {
        ListNode dum = new ListNode();
        ListNode cur = dum;
        while (l != null && r != null) {
            if (l.val < r.val) {
                cur.next = l;
                l = l.next;
            } else {
                cur.next = r;
                r = r.next;
            }
            cur = cur.next;
        }

        if (l != null) {
            cur.next = l;
        } else {
            cur.next = r;
        }
        return dum.next;
    }

    public static void main(String[] args) {
        ListNode l = new ListNode(4);
        l.next = new ListNode(3);
        l.next.next = new ListNode(2);
        l.next.next.next = new ListNode(6);
        l.next.next.next.next = new ListNode(5);
        l.next.next.next.next.next = new ListNode(7);
        l.next.next.next.next.next.next = new ListNode(1);

        ListNode r = new ListNode(1);
        r.next = new ListNode(2);
        SortList ii = new SortList();
        System.out.println(ii.sortListTwo(l));
//        for (int i = 0; i < 10; i++) {
//            System.out.println(i);
//        }
    }
}
