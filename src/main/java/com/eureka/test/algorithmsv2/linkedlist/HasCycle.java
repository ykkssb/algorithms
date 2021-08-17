package com.eureka.test.algorithmsv2.linkedlist;

import com.eureka.test.container.ListNode;

import java.util.Arrays;

/**
 * <p>141. 环形链表</p>
 * https://leetcode-cn.com/problems/linked-list-cycle
 *
 * @Author : Eric
 * @Date: 2021-01-21 20:50
 */
public class HasCycle {
    public boolean hasCycle(ListNode head) {
        if(head==null|| head.next ==null){
            return false;
        }
        ListNode l = head, r=head;
        while(r!=null && r.next!=null){
            l = l.next;
            r =r.next.next;
            if(l==r){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        HasCycle hc = new HasCycle();
        ListNode l = new ListNode();
        l.val = 1;
        l.next = new ListNode(2);
        System.out.println(hc.hasCycle(l));



    }
}
