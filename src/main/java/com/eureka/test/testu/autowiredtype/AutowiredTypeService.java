package com.eureka.test.testu.autowiredtype;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * <p></p>
 *
 * @Author : Eric
 * @Date: 2021-03-26 11:15
 */
@Component
public class AutowiredTypeService {
    @Autowired
    Hunter hunter1;

    public void show(){
        hunter1.display();
    }
}
