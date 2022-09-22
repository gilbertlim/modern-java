package com.gilbert.modern.Lambda;

import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class UseRunnable {
    Runnable r1 = () -> System.out.println("Hello World 1");

    Runnable r2 = new Runnable() {
        public void run() {
            System.out.println("Hello Word 2");
        }
    };

    public static void process(Runnable r1) {
        r1.run();
    }

    @EventListener(ApplicationStartedEvent.class)
    public void main() {
        process(r1);
        process(r2);
        process(() -> {System.out.println("Hello World 3");});

    }
}
