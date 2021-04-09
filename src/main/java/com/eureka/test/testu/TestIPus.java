package com.eureka.test.testu;

import org.springframework.util.StopWatch;

/**
 * <p>测试i++ 和++i的区别</p>
 *
 * @Author : Eric
 * @Date: 2021-04-01 00:18
 */
public class TestIPus {
    public static void main(String[] args) {
        StopWatch s = new StopWatch();
        String st = "";
        s.start();
        for (int i = 0; i < 10000; i++) {
            st = String.valueOf(i);
        }
        s.stop();
        System.out.println("first" + s.prettyPrint());

        s.start();

        for (int i = 0; i < 10000; ++i) {
            st = String.valueOf(i);

        }
        s.stop();
        System.out.println("second" + s.prettyPrint());
    }
}
