package com.gilbert.modern.FunctionalInterface.Consumer;

import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

@Component
public class UseConsumer {

    @EventListener(ApplicationStartedEvent.class)
    public void main() {
        System.out.println("===== Functional Interface / Lambda =====");

        forEach(
                Arrays.asList(1, 2, 3, 4, 5),
                System.out::println
        );

    }

    public <T> void forEach(List<T> list, Consumer<T> c) {
        for (T t : list) {
            c.accept(t);
        }
    }
}
