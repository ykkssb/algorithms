package com.eureka.test.algorithmsv2.linkedlist;

import com.eureka.test.container.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>234. 回文链表</p>
 * https://leetcode-cn.com/problems/palindrome-linked-list/
 *
 * @Author : Eric
 * @Date: 2021-01-20 15:15
 */
public class IsPalindrome {

    /**
     * 方法一：将值复制到数组中后用双指针法
     *
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        List<Integer> res = new ArrayList<>();
        ListNode form = head;
        while (form != null) {
            res.add(form.val);
            form = form.next;
        }
        int l = 0, r = res.size() - 1;
        while (l <= r) {
            if (!res.get(l).equals(res.get(r))) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    /**
     * 快慢指针
     *
     * @param head
     * @return
     */
    public boolean isPalindromeTwo(ListNode head) {
        ListNode cur = null, pre = head;
        ListNode slow = head, fast = head;

        // 1-2-3-3-2-1
        while (fast != null && fast.next != null) {
            pre = slow;

            slow = slow.next;
            fast = fast.next.next;
            pre.next = cur;
            cur = pre;
        }
        // 奇数
        if (fast != null) {
            slow = slow.next;
        }

        while(slow!=  null &&  cur!=null){
            if(slow.val!=cur.val){
                return false;
            }
            slow = slow.next;
            cur = cur.next;
        }
        return true;
    }

    /**
     * 快慢指针思想找中间值
     */
    public ListNode half(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    /**
     * 链表反转
     *
     * @param head
     * @return
     */
    public ListNode reverse(ListNode head) {
        ListNode cur = null;
        ListNode pre = head;
        while (pre != null) {
            ListNode tmp = pre.next;
            pre.next = cur;
            cur = pre;
            pre = tmp;
        }
        return cur;
    }

    // 1-2-2-1
    public static void main(String[] args) {
        ListNode l = new ListNode();
        l.val = 1;
        l.next = new ListNode(1);
        l.next.next = new ListNode(4);
        l.next.next.next = new ListNode(2);
        l.next.next.next.next = new ListNode(1);

        IsPalindrome gd = new IsPalindrome();
        System.out.println(gd.isPalindromeTwo(l));
    }
}
