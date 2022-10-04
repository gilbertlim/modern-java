package com.gilbert.modern.Stream.Utilization;

import com.gilbert.modern.Stream.Dish;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Searching {

    @EventListener(ApplicationStartedEvent.class)
    public void main() {
        log.info("===== Stream / Utilization / Searching =====");
        List<Dish> menu = Dish.menu();

        // match
        if (menu.stream().anyMatch(Dish::isVegetarian)) {
            log.debug("vegetarian이 하나 이상입니다."); // true
        }

        boolean result = menu.stream()
            .allMatch(dish -> dish.getCalories() < 1000);
        log.debug("result = {}", result); // true

        boolean result2 = menu.stream()
            .noneMatch(dish -> dish.getCalories() >= 1000);
        log.debug("result2 = {}", result2); // true

        // search
        menu.stream()
            .filter(Dish::isVegetarian)
            .findAny()
            .ifPresent(d -> log.debug("name= {}", d.getName()));

        menu.stream()
            .filter(Dish::isVegetarian)
            .findFirst()
            .ifPresent(d -> log.debug("name= {}", d.getName()));

        // reduce
        List<Integer> numbers = IntStream.range(1, 11).boxed().collect(Collectors.toList());
        Integer reduced = numbers.stream().reduce(0, (a, b) -> a + b);
        log.debug("reduced = {}", reduced); // 55

        int maxNumber = numbers.stream().reduce(0, Integer::max);
        log.debug("maxNumber = {}", maxNumber);
    }
}
