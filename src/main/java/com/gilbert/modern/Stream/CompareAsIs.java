package com.gilbert.modern.Stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CompareAsIs {

    @EventListener(ApplicationStartedEvent.class)
    public void main() {
        log.info("===== Stream / Compare AS Is =====");
        asIs();
    }

    public void asIs() {
        List<Dish> menu = Arrays.asList(
            new Dish("meat", 1000),
            new Dish("salad", 100)
        );
        List<Dish> lowCaloricDishes = new ArrayList<>();

        for (Dish dish : menu) {
            if (dish.getCalories() < 400) {
                lowCaloricDishes.add(dish);
            }
        }

        for (Dish lowDish : lowCaloricDishes) {
            log.debug("lowDish.getName() = {}, lowDish.getCalories() = {}", lowDish.getName(), lowDish.getCalories());
        }
    }

}
