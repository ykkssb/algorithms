package com.eureka.test.algorithms.normal;

/**
 * <p>删除链表第N个节点</p>
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 *
 * @Author : Eric
 * @Date: 2020-03-19 20:04
 */
public class RemoveNthFromEnd {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 方法二：一次遍历算法
     * 时间复杂度：O(L)，该算法对含有 L 个结点的列表进行了一次遍历。因此时间复杂度为 O(L)
     * 空间复杂度：O(1)
     *
     * @param head
     * @param n
     * @return
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode sec = dummy;

        for (int i = 1; i <= n; i++) {
            first = first.next;
        }

        while (first.next != null) {
            first = first.next;
            sec = sec.next;
        }

        sec.next = sec.next.next;
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode n = new ListNode(1);
        n.next = new ListNode(2);
        n.next.next = new ListNode(3);
        n.next.next.next = new ListNode(4);
        n.next.next.next.next = new ListNode(5);
        System.out.println(removeNthFromEnd(n, 2));
    }

}
