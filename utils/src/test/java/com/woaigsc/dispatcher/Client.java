package com.woaigsc.dispatcher;

import com.woaigsc.dispatcher.event.ClickEvent;
import com.woaigsc.dispatcher.event.DbClickEvent;
import com.woaigsc.dispatcher.event.Event;
import com.woaigsc.dispatcher.listener.ClickEventListener;
import com.woaigsc.dispatcher.listener.DbClickEventListener;
import com.woaigsc.dispatcher.source.Button;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by chuiyuan on 16-4-23.
 */
public class Client {
    private Event currentEvent ;
    private Button button ;

    @Before
    public void initComponent(){
        button = new Button();

        button.addEventListener(new ClickEventListener() {
            @Override
            public void handleEvent(ClickEvent event) {
                System.out.println("Button clicked");
            }
        });

        button.addEventListener(new DbClickEventListener() {
            @Override
            public void handleEvent(DbClickEvent event) {
                System.out.println("Button double clicked");
            }
        });
    }

    @Test
    public void testCommonEvents(){
        currentEvent = new ClickEvent();
        button.notifyListeners(currentEvent);

        currentEvent = new DbClickEvent();
        button.notifyListeners(currentEvent);

    }
}





