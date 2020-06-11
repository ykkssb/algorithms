package com.eureka.test.algorithms.normal;

import com.eureka.test.algorithms.container.ListNode;

/**
 * <p>旋转链表</p>
 * https://leetcode-cn.com/problems/rotate-list/solution/61java-0msda-bai-bai-fen-bai-xiang-xi-tu-jie-by-us/
 *
 * @Author : Eric
 * @Date: 2020-05-09 20:03
 */
public class RotateRight {



    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null) {
            return head;
        }
        ListNode tail = head;
        int index = 1;
        while (tail.next != null) {
            index++;
            tail = tail.next;
        }

        k = k % index;
        if (k == 0) {
            return head;
        }

        ListNode pre = head;
        for (int i = 1; i < index - k; i++) {
            pre = pre.next;
        }
        ListNode res = pre.next;
        pre.next = null;
        tail.next = head;

        return res;
    }


    public static void main(String[] args) {
        ListNode n = new ListNode(1);

        n.next = new ListNode(2);
        n.next.next = new ListNode(3);
        n.next.next.next = new ListNode(4);
        n.next.next.next.next = new ListNode(5);
        RotateRight t = new RotateRight();

        System.out.println(t.rotateRight(n, 1));
    }

}
