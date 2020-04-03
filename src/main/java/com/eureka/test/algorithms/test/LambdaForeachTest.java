package com.eureka.test.algorithms.test;

import com.google.common.collect.Lists;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.time.StopWatch;

import java.util.List;

/**
 * <p></p>
 *
 * @Author : Eric
 * @Date: 2020-04-01 11:09
 */
@Slf4j
public class LambdaForeachTest {
    private static List<Integer> list = Lists.newArrayList();
//
//    static {
//        log.info("构造函数初始化100W数据开始");
//
//        for (int i = 0; i < 10000000; i++) {
//            list.add(i);
//        }
//        log.info("构造函数初始化100W数据结束");
//    }

    public static void main(String[] args) {
        log.info("开始main");
        StopWatch s = new StopWatch();
        s.start();
//        List<User> users = Lists.newArrayList();
//        list.stream().filter(Objects::nonNull).forEach(e -> {
//            User u = new User();
//            u.setAge(e);
//            users.add(u);
//        });
        for (int i = 0; i < 10000000; i++) {
            list.add(i);
        }
        s.split();
        log.info("遍历结束时间->{}", s.getSplitTime());
    }

    @Getter
    @Setter
    public static class User {
        private String name;
        private Integer age;
    }
}
