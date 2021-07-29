package com.eureka.test.designmodel.observer.event;

/**
 * <p></p>
 *
 * @Author : Eric
 * @Date: 2021-07-13 14:39
 */
public class TeachEventListener implements BellEventListener {
    @Override
    public void heardBell(RingEvent e) {
        if (e.getSound()) {
            System.out.println("老师上课了...");
        } else {
            System.out.println("老师下课了...");
        }
    }
}
