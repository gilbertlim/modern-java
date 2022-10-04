package com.gilbert.modern.Stream.Utilization;

import com.gilbert.modern.Stream.Dish;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Filtering {

    @EventListener(ApplicationStartedEvent.class)
    public void main() {
        log.info("===== Stream / Utilization / Filtering =====");
        List<Dish> menu = Dish.menu();

        // filter
        List<Dish> vegetarianMenu = menu.stream().filter(Dish::isVegetarian).collect(Collectors.toList());

        vegetarianMenu.forEach(m -> log.debug("Name : {}, Vegetarian : {}", m.getName(), m.isVegetarian()));

        // distinct
        List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 4, 2);

        List<Integer> distinctResult = numbers.stream().filter(i -> i % 2 == 0).distinct().collect(Collectors.toList());
        distinctResult.stream().forEach(r -> log.debug("result : {}", r.toString())); // 2, 4


    }
}
