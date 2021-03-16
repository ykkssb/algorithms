package com.eureka.test.algorithms.easy;

import com.eureka.test.container.ListNode;

/**
 * <p>删除排序链表中的重复元素</p>
 *
 * @Author : Eric
 * @Date: 2020-06-12 18:41
 */
public class DeleteDuplicatesTwo {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;

        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {

                ListNode tmp = cur.next;
                while(cur.next!=null && cur.next.next!=null &&
                cur.next.val ==cur.next.next.val){
                    tmp = cur.next;
                }

                cur.next = tmp;

            }else{
                cur = cur.next;
            }

        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(1);
        l1.next.next = new ListNode(2);
        l1.next.next.next = new ListNode(3);
        l1.next.next.next.next = new ListNode(4);
        l1.next.next.next.next.next = new ListNode(5);
        DeleteDuplicatesTwo d = new DeleteDuplicatesTwo();

        System.out.println(d.deleteDuplicates(l1));
    }

}
