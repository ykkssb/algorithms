package com.eureka.test.algorithmsv2.linkedlist;

import com.eureka.test.container.ListNode;

/**
 * <p>面试题 02.07. 链表相交</p>
 * https://leetcode-cn.com/problems/intersection-of-two-linked-lists-lcci/
 *
 * @Author : Eric
 * @Date: 2021-01-21 21:06
 */
public class GetIntersectionNode {
    /**
     * todo v3
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//        ListNode l = headA, r = headB;
//        while (l != r) {
//            l = l != null ? l.next : headB;
//            r = r != null ? r.next : headA;
//        }
//        return l;
        ListNode a= headA, b = headB;
        ListNode  c= a, d= b;
        while(a!=null){
            a = a.next;
            if(a.next==null){
                a.next = headB;
                break;
            }
        }
        while(b!=null){
            b = b.next;
            if(b.next==null){
                b.next = headA;
                break;
            }
        }
        while(c!=null && d!=null){
            c= c.next;
            d = d.next;
            if(c==d){
                return c;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode l = new ListNode();
        l.next = new ListNode(1);
        l.next.next = new ListNode(2);

        ListNode r = new ListNode(4);
        r.next = new ListNode(5);

        ListNode a = new ListNode(7);
        a.next = new ListNode(8);
        GetIntersectionNode g = new GetIntersectionNode();

        l.next.next.next = a;
        r.next.next = a;

        System.out.println(g.getIntersectionNode(l, r));

    }

}
