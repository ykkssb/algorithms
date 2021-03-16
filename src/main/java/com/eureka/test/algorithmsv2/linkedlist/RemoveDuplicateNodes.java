package com.eureka.test.algorithmsv2.linkedlist;

import com.eureka.test.container.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * <p>面试题 02.01. 移除重复节点</p>
 * https://leetcode-cn.com/problems/remove-duplicate-node-lcci/
 *
 * @Author : Eric
 * @Date: 2021-01-20 23:47
 */
public class RemoveDuplicateNodes {
    //todo set
    public ListNode removeDuplicateNodes(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode cur = head;
        Set<Integer> set = new HashSet<>();
        set.add(head.val);
        // 1-2-3-3-2-1
        while (cur.next != null) {
            ListNode tmp = cur.next;
            if (set.contains(tmp.val)) {
                cur.next = tmp.next;
            } else {
                set.add(tmp.val);
                cur.next = tmp;
                cur = cur.next;
            }
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode l = new ListNode();
        l.val = 1;
        l.next = new ListNode(2);
        l.next.next = new ListNode(3);
        l.next.next.next = new ListNode(3);
        l.next.next.next.next = new ListNode(2);
        l.next.next.next.next.next = new ListNode(1);
        RemoveDuplicateNodes n = new RemoveDuplicateNodes();
        System.out.println(n.removeDuplicateNodes(l));
    }
}
