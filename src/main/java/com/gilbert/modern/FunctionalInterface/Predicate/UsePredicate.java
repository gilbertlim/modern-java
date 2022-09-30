package com.gilbert.modern.FunctionalInterface.Predicate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class UsePredicate {

    @EventListener(ApplicationStartedEvent.class)
    public void main() {
        log.info("===== Functional Interface / Lambda =====");

        List<String> listOfStrings = new ArrayList<>(Arrays.asList("a", "b", "", "c"));

        Predicate<String> nonEmptyStringPredicate = (String s) -> !s.isEmpty();
        List<String> nonEmpty = filter(listOfStrings, nonEmptyStringPredicate);

        log.debug("nonEmpty = " + nonEmpty);

        IntPredicate evenNumbers = (int i) -> i % 2 == 0;
        evenNumbers.test(1000);


    }

    public <T> List<T> filter(List<T> list, Predicate<T> p) {
        List<T> results = new ArrayList<>();
        for (T t : list) {
            if (p.test(t)) {
                results.add(t);
            }
        }

        return results;
    }
}
