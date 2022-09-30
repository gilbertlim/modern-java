package com.gilbert.modern.Lambda.MethodReference;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MethodReference {

    @EventListener(ApplicationStartedEvent.class)
    public void main() {
        log.info("===== Method Reference =====");

        List<String> str = Arrays.asList("a", "b", "A", "D");
        str.sort(String::compareToIgnoreCase);

        log.debug("str = " + str);

        ToIntFunction<String> stringToInt = Integer::parseInt;

        int number = stringToInt.applyAsInt("0") + 1;
        log.debug("number + 1 = " + number);

        BiPredicate<List<String>, String> contains = List::contains;
        boolean existA = contains.test(str, "a");
        log.debug("existA = " + existA);

        Predicate<String> startsWithNumber = this::startsWithNumber;
        boolean isStartedNumber = startsWithNumber.test("1sdasd");
        log.debug("isStartedNumber = " + isStartedNumber);

    }


    public Boolean startsWithNumber(String s) {
        return Character.isDigit(s.charAt(0));
    }
}
