package com.eureka.test.designmodel.observer.event;

import java.util.EventObject;

/**
 * <p></p>
 *
 * @Author : Eric
 * @Date: 2021-07-13 14:37
 */
public class RingEvent extends EventObject {
    private static final long serialVersionUID = 1L;
    //true表示上课铃声,false表示下课铃声
    private boolean sound;

    public RingEvent(Object source, boolean sound) {
        super(source);
        this.sound = sound;
    }

    public void setSound(boolean sound) {
        this.sound = sound;
    }

    public boolean getSound() {
        return this.sound;
    }
}
