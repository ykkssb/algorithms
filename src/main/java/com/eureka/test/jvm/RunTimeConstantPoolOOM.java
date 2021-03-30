package com.eureka.test.jvm;

import java.util.HashSet;
import java.util.Set;

/**
 * <p></p>
 *
 * @Author : Eric
 * @Date: 2021-03-29 17:07
 */
public class RunTimeConstantPoolOOM {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        short i =0;
        for(;;){
            set.add(String.valueOf(i++).intern());
        }
    }
}
