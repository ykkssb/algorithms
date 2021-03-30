package com.eureka.test.testu.autowiredtype;

import org.springframework.stereotype.Component;

/**
 * <p></p>
 *
 * @Author : Eric
 * @Date: 2021-03-26 11:15
 */
@Component
public class Hunter2 implements Hunter {
    @Override
    public void display() {
        System.out.println("hunter2");
    }
}
