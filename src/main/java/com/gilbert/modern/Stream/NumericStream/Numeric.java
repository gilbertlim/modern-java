package com.gilbert.modern.Stream.NumericStream;

import com.gilbert.modern.Stream.Dish;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Numeric {

    @EventListener(ApplicationStartedEvent.class)
    public void main() {
        log.info("===== Stream / Numeric Stream =====");

        List<Dish> menu = Dish.menu();

        // Primitive Stream Specialization

        int calories = menu.stream()
            .mapToInt(Dish::getCalories) // InStream으로 변환
            .sum();

        OptionalInt maxCalories = menu.stream() // Optional 제공
            .mapToInt(Dish::getCalories)
            .max();

        int maxCaloriesWithDefault = menu.stream() // Optional + Default
            .mapToInt(Dish::getCalories)
            .max()
            .orElse(1);

        Stream<Integer> boxedStream = menu.stream()
            .mapToInt(Dish::getCalories)
            .boxed(); // 특화 스트림을 일반 스트림으로 변환

        // Range

        OptionalInt maxValue = IntStream.rangeClosed(1, 100)
            .max();
        log.debug("maxValue = {}", maxValue); // 100

        Stream<double[]> pythagoreanTriples = IntStream.rangeClosed(1, 100)
            .boxed()
            .flatMap(a -> IntStream.rangeClosed(a, 100)
                .mapToObj(b -> new double[]{a, b, Math.sqrt(a * a + b * b)})
                .filter(t -> t[2] % 1 == 0)
            );

        pythagoreanTriples.limit(5)
            .forEach(v -> log.debug("pythagoreanTriples ={}", v));
    }
}
