package com.eureka.test.container;

import lombok.Data;

/**
 * <p></p>
 *
 * @Author : Eric
 * @Date: 2021-03-01 18:25
 */
public class Dnode {
    private String res;

    private int left;

    private int right;

    public Dnode(String res, int left, int right) {
        this.res = res;
        this.left = left;
        this.right = right;
    }
}
