package com.eureka.test.algorithmsv2.linkedlist;

import com.eureka.test.algorithms.container.ListNode;

/**
 * <p>19. 删除链表的倒数第 N 个结点</p>
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 *
 * @Author : Eric
 * @Date: 2021-01-20 23:22
 */
public class RemoveNthFormEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return head;
        }
        ListNode dum = new ListNode(0, head);
        ListNode s=dum, f = dum;
        while (n>0){
            f = f.next;
            n--;
        }
        while (f.next!=null){
            f = f.next;
            s = s.next;
        }
        s.next = s.next.next;
        return dum.next;
    }


    // 0-1-2-3-4-5

    /**
     * 引入哑结点处理边界问题
     */
    public static void main(String[] args) {
        ListNode l = new ListNode();
        l.val = 1;
        l.next = new ListNode(2);
        l.next.next = new ListNode(3);
        l.next.next.next = new ListNode(4);
        l.next.next.next.next = new ListNode(5);
        RemoveNthFormEnd n = new RemoveNthFormEnd();
        System.out.println(n.removeNthFromEnd(l, 2));
    }
}
