package com.eureka.test.algorithms.hard;

import com.eureka.test.algorithms.container.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * <p>合并链表</p>
 * https://leetcode-cn.com/problems/merge-k-sorted-lists/
 *
 * @Author : Eric
 * @Date: 2020-03-22 14:47
 */
public class MergeNodeList {


    /**
     * 分而治之
     *
     * @param lists
     * @return
     */
    public static ListNode mergeKLists(ListNode[] lists) {
        int n = lists.length;
        if (n == 0) {
            return null;
        }
        while (n > 1) {
            int i;
            for (i = 0; i < n / 2; i++) {
                lists[i] = mergeNode(lists[2 * i], lists[2 * i + 1]);
            }

            if (n % 2 != 0) {
                lists[i] = lists[n - 1];
                n = n + 1;
            }

            n = n / 2;
        }

        return lists[0];
    }


    public static ListNode mergeNode(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (l1 != null || l2 != null) {

            if (l1 == null) {
                cur.next = l2;
                break;
            } else if (l2 == null) {
                cur.next = l1;
                break;
            }


            if (l1.val <= l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }

        return dummy.next;
    }

    /**
     * 需要一种辅助数据结构-堆
     *
     * @param lists
     * @return
     */
    public static ListNode mergeKListsTwo(ListNode[] lists) {
        int n = lists.length;
        if (n == 0) {
            return null;
        }
        PriorityQueue<ListNode> queue = new PriorityQueue(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }

            @Override
            public boolean equals(Object obj) {
                return false;
            }
        });

        for (int i = 0; i < n; i++) {
            ListNode head = lists[i];
            if (head != null) {
                queue.add(head);
            }
        }


        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            cur.next = node;
            cur = cur.next;
            if (node != null && node.next != null) {
                queue.add(node.next);
            }
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(3);
        l1.next.next = new ListNode(5);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(2);
        l2.next.next = new ListNode(4);
        ListNode[] ls = {l1, l2};
        System.out.println(mergeKListsTwo(ls));
    }
}
