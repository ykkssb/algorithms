package com.eureka.test.algorithmsv2.linkedlist;

import com.eureka.test.container.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>剑指 Offer 24. 反转链表</p>
 * https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof/
 * https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/
 *
 * @Author : Eric
 * @Date: 2021-01-20 16:38
 */
public class ReverseList {
    /**
     * 反转链表
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        ListNode pre = head, cur = null;
        while (pre != null) {
            ListNode t = pre.next;
            pre.next = cur;
            cur = pre;
            pre = t;
        }
        return cur;
    }

    /**1 2 3 2 1
     * 方法二：递归
     * todo v2
     *
     * @param head
     * @return
     */
    // 1-2-3-4-5-nullz
    public ListNode reverseListTwo(ListNode head) {
        if (head==null || head.next==null){
            return head;
        }

        ListNode tmp = reverseListTwo(head.next);
        head.next.next = head;
        head.next = null;
        return tmp;
    }

    public int[] reversePrint(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode cur = null, pre = head;
        while (pre != null) {
            list.add(pre.val);
            ListNode tmp = pre.next;
            pre.next = cur;
            cur = pre;
            pre = tmp;
        }
        int n = list.size() - 1;
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(n - i);
        }
        return res;
    }

    public static void main(String[] args) {
        ListNode l = new ListNode();
        l.val = 1;
        l.next = new ListNode(2);
        l.next.next = new ListNode(3);
        l.next.next.next = new ListNode(4);
        l.next.next.next.next = new ListNode(5);

        // 1-2-3-4-5
        ReverseList r = new ReverseList();
//        System.out.println(r.reverseList(l));
        System.out.println(r.reverseListTwo(l));
    }
}
