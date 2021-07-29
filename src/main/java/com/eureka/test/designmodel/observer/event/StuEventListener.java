package com.eureka.test.designmodel.observer.event;

/**
 * <p></p>
 *
 * @Author : Eric
 * @Date: 2021-07-13 14:39
 */
public class StuEventListener implements BellEventListener {
    @Override
    public void heardBell(RingEvent e) {
        if (e.getSound()) {
            System.out.println("同学们，上课了...");
        } else {
            System.out.println("同学们，下课了...");
        }
    }
}
