package com.eureka.test.algorithms.test;

import com.netflix.discovery.converters.wrappers.CodecWrappers;
import lombok.Data;
import lombok.ToString;
import org.springframework.boot.json.JacksonJsonParser;

/**
 * <p></p>
 *
 * @Author : Eric
 * @Date: 2020-05-15 14:28
 */
@Data
public class Person {
    private String name;
    private int age;

    public static void main(String[] args) {
        Person p = new Person();
        p.setName("name");
        p.setAge(1);
        ss(p);
        System.out.println("----");
    }
    private static void ss (Person p){
        p.setName("ss");
        p.setAge(2);

    }
}
