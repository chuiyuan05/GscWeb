package com.woaigsc.dispatcher.source;

import com.woaigsc.dispatcher.event.Event;
import com.woaigsc.dispatcher.listener.EventListener;

import java.util.LinkedList;

/**
 * Created by chuiyuan on 16-4-23.
 */
public class Button implements EventSource {
    protected java.util.List<EventListener<? extends Event>> listeners =
            new LinkedList<EventListener<
            ? extends Event>>();

    @Override
    public void addEventListener(EventListener<? extends Event> listener) {
        listeners.add(listener);
    }

    @Override
    public void removeEventListener(EventListener<? extends Event> listener) {
        listeners.remove(listener);
    }

    @Override
    public void notifyListeners(Event event) {
        for(EventListener listener: listeners){
            try {
                listener.handleEvent(event);
            }catch (ClassCastException e){
                e.printStackTrace();
            }
        }
    }
}
