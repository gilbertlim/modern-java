package com.gilbert.modern.Etc;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;

// @Component
@Slf4j
public class MeaningOfThis {

    public final int value = 4;

    @EventListener(ApplicationStartedEvent.class)
    public void doIt() {
        log.info("===== Meaning Of This =====");

        int value = 6;
        Runnable r = new Runnable() {
            public final int value = 5;

            @Override
            public void run() {
                int value = 10;
                log.debug("value : " + this.value);
                // Runnable은 익명클래스이다. run 메서드는 Runnable 객체 안에 있기 때문에 this는 Runnable을 의미한다.
            }
        };

        r.run();
    }
}
