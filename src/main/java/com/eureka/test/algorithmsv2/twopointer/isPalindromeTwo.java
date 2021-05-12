package com.eureka.test.algorithmsv2.twopointer;

import com.eureka.test.container.ListNode;

/**
 * <p>234. 回文链表</p>
 * https://leetcode-cn.com/problems/palindrome-linked-list/
 *
 * @Author : Eric
 * @Date: 2021-01-19 22:02
 */
public class isPalindromeTwo {
    public boolean isPalindrome(ListNode head) {
        ListNode s = head, f=head;
        ListNode cur = null, pre =head;
        while(f!=null && f.next!=null){
            pre =s;
            s = s.next;
            f= f.next.next;
            pre.next = cur;
            cur = pre;
        }
        if(f!=null){
            s = s.next;
        }
        while(s!=null){
            if(s.val!=cur.val){
                return false;
            }
            s = s.next;
            cur = cur.next;
        }
        return true;
    }

}
