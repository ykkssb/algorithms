package com.eureka.test.testu;

import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.concurrent.*;

/**
 * <p></p>
 *
 * @Author : Eric
 * @Date: 2021-03-28 14:03
 */
@Component
public class ThreadPoolTest {
    private static ExecutorService executor = new ThreadPoolExecutor(
            4, 4, 1000L, TimeUnit.SECONDS,
            new LinkedBlockingQueue<>(10), new ThreadPoolExecutor.AbortPolicy());

    public static void main(String[] args) {
        executor.execute(() -> {
        });
        System.out.println("a");
        System.out.println("b");
        System.out.println("c");
        System.out.println("d");
        System.out.println("e");
        System.out.println("f");
        System.out.println("g");
        System.out.println("z");
        System.out.println("x");
        System.out.println("c");

        System.out.println("a1");
        System.out.println("a2");
        System.out.println("c1");
        System.out.println("c2");
    }
}
