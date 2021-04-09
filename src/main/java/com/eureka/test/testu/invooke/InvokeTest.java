package com.eureka.test.testu.invooke;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * <p>反射</p>
 *
 * @Author : Eric
 * @Date: 2021-04-08 11:18
 */
public class InvokeTest {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
    Class clazz = Class.forName("com.eureka.test.testu.Num");
        String methodName = "print";
        Method m =clazz.getDeclaredMethod(methodName, null);
//        Object obj = clazz.newInstance();
//        m.invoke(obj);
        m.invoke(ServiceGetter.getServiceByClazz(clazz));

        System.out.println();
    }


}
