package com.gilbert.modern.FunctionalInterface.Function;

import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

@Component
public class UseFunction {

    @EventListener(ApplicationStartedEvent.class)
    public void main() {
        System.out.println("===== Functional Interface / Lambda =====");
        
        List<Integer> l = map(Arrays.asList("lambdas", "in", "action"),
                String::length
        );

        System.out.println("l = " + l);


    }

    public <T, R> List<R> map(List<T> list, Function<T, R> function) {
        List<R> result = new ArrayList<>();
        for (T t : list) {
            result.add(function.apply(t));
        }

        return result;
    }
}
