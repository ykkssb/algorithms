package com.eureka.test.testu;

import com.eureka.test.testu.autowiredtype.AppConfig;
import com.eureka.test.testu.autowiredtype.AutowiredTypeService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * <p></p>
 *
 * @Author : Eric
 * @Date: 2021-03-26 11:11
 */
public class AutowiredTypeTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext =
                new AnnotationConfigApplicationContext(AppConfig.class);
        AutowiredTypeService service = annotationConfigApplicationContext.getBean(AutowiredTypeService.class);
        service.show();
    }
}
