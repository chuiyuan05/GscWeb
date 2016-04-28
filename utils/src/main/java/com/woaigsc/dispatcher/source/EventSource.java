package com.woaigsc.dispatcher.source;

import com.woaigsc.dispatcher.event.Event;
import com.woaigsc.dispatcher.listener.EventListener;

/**
 * Created by chuiyuan on 16-4-23.
 */
public interface EventSource {
    public void addEventListener(EventListener<? extends Event> listener);

    public void removeEventListener(EventListener<? extends  Event> listener);

    public void notifyListeners(Event event);
}
