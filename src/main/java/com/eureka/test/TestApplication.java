package com.eureka.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class TestApplication {

    public static void main(String[] args) {
        System.out.println("1");
        System.out.println("2");
        System.out.println("3");
        SpringApplication.run(TestApplication.class, args);
    }

}
