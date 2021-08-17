package com.eureka.test.container;

/**
 * <p></p>
 *
 * @Author : Eric
 * @Date: 2021-08-04 10:59
 */
public class ss {
    public int val;
    public int key;
    public ss next;
    public ss pre;

    public ss() {
    }

    public ss(int key, int val, ss next, ss pre) {
        this.val = val;
        this.key = key;
        this.next = next;
        this.pre = pre;
    }
}
