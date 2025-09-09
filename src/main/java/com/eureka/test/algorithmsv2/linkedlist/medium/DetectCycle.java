package com.eureka.test.algorithmsv2.linkedlist.medium;

import com.eureka.test.container.ListNode;

/**
 *https://leetcode.cn/problems/linked-list-cycle-ii/description/?envType=problem-list-v2&envId=hash-table
 * 2. 环形链表 II
 * @author : yujie.wang
 * @date: 2025-09-09 16:55
 */
public class DetectCycle {

    public ListNode detectCycle(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode l = head;
        ListNode r= l;
        while(r!=null && r.next!=null){
            l=l.next;
            r= r.next.next;
            if(l==r){
                ListNode p  = head;
                while(p!=r){
                    r = r.next;
                    p = p.next;
                }
                return p;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode  l = new ListNode(3);
        l.next = new ListNode(2);
        ListNode  tmp = l.next;
        l.next.next = new ListNode(0);
        l.next.next.next = new ListNode(-4);
        l.next.next.next.next = tmp;

        DetectCycle d = new DetectCycle();
        System.out.println(d.detectCycle(l));
    }

}
