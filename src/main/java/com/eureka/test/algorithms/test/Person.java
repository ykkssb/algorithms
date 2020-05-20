package com.eureka.test.algorithms.test;

import com.google.common.collect.Lists;
import com.netflix.discovery.converters.wrappers.CodecWrappers;
import lombok.Data;
import lombok.ToString;
import org.springframework.boot.json.JacksonJsonParser;

import java.util.List;
import java.util.stream.Collectors;

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
        List<Person> ss = Lists.newArrayList();
        Person p = new Person();
        p.setName("name");
        p.setAge(1);
        ss.add(p);
        Person p1 = new Person();
        p1.setName("eric");
        p1.setAge(3);
        ss.add(p1);

        ss.stream().map(t -> {
                    t.setAge(2);
                    return t;
                }
        ).collect(Collectors.toList());

        System.out.println(ss.toString());

    }
}
