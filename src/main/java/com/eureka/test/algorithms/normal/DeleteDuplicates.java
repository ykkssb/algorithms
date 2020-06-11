package com.eureka.test.algorithms.normal;


import com.eureka.test.algorithms.container.ListNode;

/**
 * <p>删除排序链表中的重复元素 II</p>
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/
 *
 * @Author : Eric
 * @Date: 2020-06-11 16:37
 */
public class DeleteDuplicates {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;

        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                ListNode tmp = cur.next;

                while (tmp != null && tmp.next != null && tmp.val == tmp.next.val) {
                    tmp = tmp.next;
                }
                cur.next = tmp.next;
            } else {
                cur = cur.next;
            }

        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(3);
        l1.next.next.next.next = new ListNode(4);
        l1.next.next.next.next.next = new ListNode(5);
        DeleteDuplicates d = new DeleteDuplicates();

        System.out.println(d.deleteDuplicates(l1));
    }
}
