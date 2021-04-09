package com.eureka.test.designmodel;

/**
 * <p>单例模式</p>
 *
 * @Author : Eric
 * @Date: 2021-04-05 12:38
 */
public class SingleObject {
    private static SingleObject singleObject;

    public SingleObject() {
    }

    public static SingleObject getInstance() {
        if (singleObject == null) {
            synchronized (SingleObject.class) {
                if (singleObject == null) {
                    singleObject = new SingleObject();
                }
            }
        }
        return singleObject;
    }
}
