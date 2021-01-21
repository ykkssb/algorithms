package com.eureka.test.algorithms.container;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * <p></p>
 *
 * @Author : Eric
 * @Date: 2021-01-21 21:41
 */
@NoArgsConstructor
@AllArgsConstructor
public class Node {
    public int val;
    public Node next;
    public Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
