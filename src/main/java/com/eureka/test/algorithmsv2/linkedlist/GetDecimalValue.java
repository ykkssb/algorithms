package com.eureka.test.algorithmsv2.linkedlist;

import com.eureka.test.container.ListNode;

/**
 * <p>1290. 二进制链表转整数</p>
 * https://leetcode-cn.com/problems/convert-binary-number-in-a-linked-list-to-integer/
 *
 * @Author : Eric
 * @Date: 2021-01-19 22:56
 */
public class GetDecimalValue {

    /**
     * todo v1
     * 本题难点在移位符
     * 运算符优先级 + 优先于比较 优先 &
     * @param head
     * @return
     */
    public int getDecimalValue(ListNode head) {
        ListNode cur = head;
        int res = 0;
        while (cur!=null){
            res = (res << 1) + cur.val;
            cur = cur.next;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(1 << 1);
        ListNode l = new ListNode();
        l.val = 1;
        l.next = new ListNode(0);
        l.next.next = new ListNode(1);

        GetDecimalValue gd = new GetDecimalValue();
        System.out.println(gd.getDecimalValue(l));
    }
}
