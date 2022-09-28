package com.gilbert.modern.Lambda.MethodReference;

import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;

@Component
public class MethodReference {

    @EventListener(ApplicationStartedEvent.class)
    public void main() {
        System.out.println("===== Method Reference =====");

        List<String> str = Arrays.asList("a", "b", "A", "D");
        str.sort(String::compareToIgnoreCase);

        System.out.println("str = " + str);

        ToIntFunction<String> stringToInt = Integer::parseInt;

        int number = stringToInt.applyAsInt("0") + 1;
        System.out.println("number + 1 = " + number);

        BiPredicate<List<String>, String> contains = List::contains;
        boolean existA = contains.test(str, "a");
        System.out.println("existA = " + existA);

        Predicate<String> startsWithNumber = this::startsWithNumber;
        boolean isStartedNumber = startsWithNumber.test("1sdasd");
        System.out.println("isStartedNumber = " + isStartedNumber);

    }


    public Boolean startsWithNumber(String s) {
        return Character.isDigit(s.charAt(0));
    }
}
