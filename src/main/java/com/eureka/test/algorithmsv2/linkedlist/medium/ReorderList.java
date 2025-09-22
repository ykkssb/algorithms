package com.eureka.test.algorithmsv2.linkedlist.medium;

import com.eureka.test.container.ListNode;
import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/reorder-list/?envType=problem-list-v2&envId=linked-list
 * <p>
 * <p>
 * 143. 重排链表
 *
 * @author : yujie.wang
 * @date: 2025-09-22 17:43
 */
public class ReorderList {


    /**
     * v0 (250922 过了） 时间O(n) 空间O(n)
     *
     * @param head
     */
    public void reorderList(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        ListNode tmp = head;
        while (tmp != null) {
            list.add(tmp);
            tmp = tmp.next;
        }
        ListNode dummy = new ListNode(-1, head);
        ListNode f = dummy;
        int n = list.size();
        for (int i = 0; i < list.size(); i++) {
            int idx = 0;
            if (i % 2 == 0) {
                idx = i / 2;
            } else {
                idx = n - i / 2 - 1;
            }
            ListNode t = list.get(idx);
            f.next = t;
            t.next = null;
            f = t;
        }
    }

    /**
     * 中心点 + 链表反转 + 拼接
     * @param head
     */
    public void reorderListTwo(ListNode head) {
        ListNode f = head, s = head, m = head;
        int k = 0;
        while (f.next != null && f.next.next != null) {
            f = f.next.next;
            s = s.next;
            k++;
        }
        if (s.next == null) {
            return;
        }
        ListNode l = rev(s.next);
        s.next = null;

        //merge() 或者下面 for
        for (int i = 0; i <= k; i++) {
            ListNode tmp = m.next;
            if (l != null) {
                m.next = l;
                ListNode r = l.next;
                l.next = tmp;
                l = r;
            } else {
                m.next = tmp;
            }
            m = tmp;
        }
    }

    public ListNode rev(ListNode head) {
        ListNode pre = head, cur = null;
        while (pre != null) {
            ListNode tmp = pre.next;
            pre.next = cur;
            cur = pre;
            pre = tmp;
        }
        return cur;
    }

    public void merge(ListNode l1, ListNode l2) {
        ListNode l;
        ListNode r;
        while (l1 != null && l2 != null) {
            l = l1.next;
            r = l2.next;

            l1.next = l2;
            l2.next = l;

            l2 = r;
            l1 = l;
        }
    }

    public static void main(String[] args) {
        ReorderList rl = new ReorderList();

        ListNode l = new ListNode(1);
        l.next = new ListNode(2);
        l.next.next = new ListNode(3);
        l.next.next.next = new ListNode(4);
        rl.reorderListTwo(l);
    }

}
