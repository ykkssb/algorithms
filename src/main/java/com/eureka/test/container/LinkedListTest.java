package com.eureka.test.container;

import java.util.LinkedList;
import java.util.List;

/**
 * <p></p>
 *
 * @Author : Eric
 * @Date: 2021-03-20 18:24
 */
public class LinkedListTest {

    public static void main(String[] args) {
        List<String> ls = new LinkedList<>();
        for(int i =0;i<10;i++){
            ls.add(i + "");
        }

        ls.get(9);
    }
}
