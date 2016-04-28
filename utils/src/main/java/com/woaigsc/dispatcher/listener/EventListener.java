package com.woaigsc.dispatcher.listener;

import com.woaigsc.dispatcher.event.Event;

/**
 * Created by chuiyuan on 16-4-23.
 */
public interface EventListener <T extends Event>{
    public void handleEvent(T event);
}
