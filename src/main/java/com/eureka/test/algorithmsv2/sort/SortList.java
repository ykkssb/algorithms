package com.eureka.test.algorithmsv2.sort;

import com.eureka.test.container.ListNode;

/**
 * <p>148. 排序链表</p>
 * https://leetcode-cn.com/problems/sort-list/
 *
 * https://leetcode-cn.com/problems/sort-list/solution/pai-xu-lian-biao-di-gui-die-dai-xiang-jie-by-cherr/
 *
 * @Author : Eric
 * @Date: 2021-01-25 10:23
 */
public class SortList {

    /**
     * 1、递归法 插入排序的时间复杂度是 O(n^2)，其中 n 是链表的长度。这道题考虑时间复杂度更低的排序算法。 题目的进阶问题要求达到 O(nlogn) 的时间复杂度和 O(1) 的空间复杂度， 时间复杂度是O(nlogn)
     * 的排序算法包括归并排序、堆排序和快速排序（快速排序的最差时间复杂度是 O(n^2)其中最适合链表的排序算法是归并排序。 所以不推荐插入排序 4-3-2-1
     * <p>
     * todo 归并排序(250925) v2(250928)
     */
    public ListNode sortList(ListNode head) {
        // 如果链表为空或者只有一个节点，无需排序  head==null兼容空链表
        if (head.next == null || head == null) {
            return head;
        }
        // 找到中间节点 head2，并断开 head2 与其前一个节点的连接
        // 比如 head=[4,2,1,3]，那么 middleNode 调用结束后 head=[4,2] head2=[1,3]
        ListNode head2 = middleNode(head);
        // 分治
        head = sortList(head);
        head2 = sortList(head2);
        // 合并
        return mergeTwoLists(head, head2);
    }

    /**
     * 876. 链表的中间结点（快慢指针）
     */
    private ListNode middleNode(ListNode head) {
        ListNode pre = head;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            // 记录 slow 的前一个节点
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        // todo 重点 断开连接 返回slow
        pre.next = null;
        return slow;
    }

    /**
     * 合并两个有序链表（双指针）
     */
    private ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // 用哨兵节点简化代码逻辑
        ListNode dummy = new ListNode();
        // cur 指向新链表的末尾
        ListNode cur = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                // 把 list1 加到新链表中
                cur.next = list1;
                list1 = list1.next;
            } else {
                // 注：相等的情况加哪个节点都是可以的
                // 把 list2 加到新链表中
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }
        // 拼接剩余链表
        cur.next = list1 != null ? list1 : list2;
        return dummy.next;

    }


    public static void main(String[] args) {
        ListNode l = new ListNode(4);
        l.next = new ListNode(2);
        l.next.next = new ListNode(1);
        l.next.next.next = new ListNode(3);
//        l.next.next.next.next = new ListNode(5);
//        l.next.next.next.next.next = new ListNode(7);
//        l.next.next.next.next.next.next = new ListNode(1);

        SortList sl = new SortList();
        ListNode listNode = sl.sortList(l);
        System.out.println(listNode.toString());
        System.out.println("1");
//        ListNode r = new ListNode(1);
//        r.next = new ListNode(2);
//        SortList ii = new SortList();
//        System.out.println(ii.sortList(l));
//        for (int i = 0; i < 10; i++) {
//            System.out.println(i);
//        }
    }
}
