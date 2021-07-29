package com.eureka.test.designmodel.observer.event;

import java.util.EventListener;

/**
 * <p></p>
 *
 * @Author : Eric
 * @Date: 2021-07-13 14:38
 */
public interface BellEventListener extends EventListener {
    //事件处理方法，听到铃声
    public void heardBell(RingEvent e);
}
