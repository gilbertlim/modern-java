package com.gilbert.modern.Lambda;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class UseRunnable {

    Runnable r1 = () -> log.debug("Hello World 1");

    Runnable r2 = new Runnable() {
        public void run() {
            log.debug("Hello Word 2");
        }
    };

    public static void process(Runnable r1) {
        r1.run();
    }

    @EventListener(ApplicationStartedEvent.class)
    public void main() {
        log.info("===== Lambda / Runnable =====");

        process(r1);
        process(r2);
        process(() -> {
            log.debug("Hello World 3");
        });

    }
}
