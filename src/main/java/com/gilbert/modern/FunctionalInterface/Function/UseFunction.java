package com.gilbert.modern.FunctionalInterface.Function;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class UseFunction {

    @EventListener(ApplicationStartedEvent.class)
    public void main() {
        log.info("===== Functional Interface / Lambda =====");

        List<Integer> l = map(Arrays.asList("lambdas", "in", "action"),
            String::length
        );

        log.debug("l = " + l);


    }

    public <T, R> List<R> map(List<T> list, Function<T, R> function) {
        List<R> result = new ArrayList<>();
        for (T t : list) {
            result.add(function.apply(t));
        }

        return result;
    }
}
