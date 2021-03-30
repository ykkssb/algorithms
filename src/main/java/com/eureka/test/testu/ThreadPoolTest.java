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
    }
}
