package com.gilbert.modern.FunctionalInterface.Consumer;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class UseConsumer {

    @EventListener(ApplicationStartedEvent.class)
    public void main() {
        log.info("===== Functional Interface / Lambda =====");

        forEach(
            Arrays.asList(1, 2, 3, 4, 5),
            x -> log.debug(x.toString())
        );

    }

    public <T> void forEach(List<T> list, Consumer<T> c) {
        for (T t : list) {
            c.accept(t);
        }
    }
}
