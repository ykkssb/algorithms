package com.eureka.test.testu.autowiredtype;

import org.springframework.stereotype.Component;

/**
 * <p></p>
 *
 * @Author : Eric
 * @Date: 2021-03-26 11:12
 */
@Component
public class Hunter1 implements Hunter {
    @Override
    public void display() {
        System.out.println("hunter1");
    }
}
