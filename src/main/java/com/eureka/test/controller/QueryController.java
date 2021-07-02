package com.eureka.test.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p></p>
 *
 * @Author : Eric
 * @Date: 2021-05-31 18:04
 */
@RestController
public class QueryController {
    @RequestMapping("/hello")
    public String index() {

        return "aaaaaa";
    }
}
