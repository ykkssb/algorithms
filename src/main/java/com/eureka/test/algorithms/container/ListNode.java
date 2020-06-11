package com.eureka.test.algorithms.container;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * <p>链表</p>
 *
 * @Author : Eric
 * @Date: 2020-03-23 20:01
 */
@NoArgsConstructor
@AllArgsConstructor
public class ListNode {

    public int val;

    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

}
