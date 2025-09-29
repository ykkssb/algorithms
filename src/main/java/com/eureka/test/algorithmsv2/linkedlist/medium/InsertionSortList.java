package com.eureka.test.algorithmsv2.linkedlist.medium;

import com.eureka.test.container.ListNode;

/**
 * <p>147. 对链表进行插入排序</p>
 * https://leetcode-cn.com/problems/insertion-sort-list/
 *
 * @Author : Eric
 * @Date: 2021-01-23 00:04
 */
public class InsertionSortList {

    /**
     * todo 插入排序思想
     * -1- 5- 3-4 -0
     *
     * @param head
     * @return
     */
    public ListNode insertionSortList(ListNode head) {

        // 0-113423
        ListNode dum = new ListNode(0, head);
        ListNode pre = dum.next, cur = head.next;
        while (cur != null) {
            if (pre.val <= cur.val) {
                pre = pre.next;
            } else {
                ListNode t = dum;
                while (t.next.val < cur.val) {
                    t = t.next;
                }
                ListNode next = t.next;
                pre.next = cur.next;
                t.next = cur;
                cur.next = next;
            }
            cur = pre.next;
        }
        return dum.next;

    }

    /**
     * 插入排序
     * <p>
     * todo V3（250928）
     */
    public ListNode insertionSortListTwo(ListNode head) {
        ListNode dummy = new ListNode(-1, head);
        ListNode cur = dummy.next;
        ListNode next = cur.next;
        while (next != null) {

            if (cur.val <= next.val) {
                // cur 代表最大值
                cur = cur.next;
            } else {
                ListNode pre = dummy;
                while (pre.next.val <= next.val) {
                    pre = pre.next;
                }
                cur.next = next.next;
                // todo 重点这里(4,2,1,) next=1 cur =4;
                //  next.next = cur就漏了2
                next.next = pre.next;;
                pre.next = next;

            }
            next = cur.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode l = new ListNode();
        l.val = 4;
        l.next = new ListNode(2);
        l.next.next = new ListNode(1);
        l.next.next.next = new ListNode(3);
//        l.next.next.next.next = new ListNode(0);
        InsertionSortList ii = new InsertionSortList();
        System.out.println(ii.insertionSortListTwo(l));
    }
}
