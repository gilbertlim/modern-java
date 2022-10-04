package com.gilbert.modern.Stream.Basic;

import com.gilbert.modern.Stream.Dish;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
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
        toBe();
        getThreeHighCaloricDishNames();
    }

    public void getThreeHighCaloricDishNames() {
        List<Dish> menu = Dish.menu();

        List<String> threeHighCaloricDishNames = menu.stream()
            .filter(d -> {
                log.debug("filtering: {}", d.getName());
                return d.getCalories() > 300;
            }) // 람다를 인수로 받아 스트림에서 특정 요소 제외
            .map(d -> {
                log.debug("mapping: {}", d.getName());
                return d.getName();
            }) // 람다를 이용해서 요소를 변환하거나 정보를 추출
            .limit(3) //스트림의 크기 축소(truncate)
            .collect(Collectors.toList()); // 파이프라인 처리 후 스트림을 다른 형식으로 결과 변환

        log.debug("threeHighCaloricDishNames : {}", threeHighCaloricDishNames);
    }

    public void toBe() {
        List<Dish> menu = Dish.menu();

        List<String> lowCaloricDishesName = menu.stream().filter(d -> d.getCalories() < 400) // 조건
            .sorted(Comparator.comparing(Dish::getCalories)) // 정렬
            .map(Dish::getName) // 추출
            .collect(Collectors.toList()); // 저장

        lowCaloricDishesName.stream().forEach(d -> log.debug("toBe.dishName: {}", d)); // 로깅
    }

    public void asIs() {
        List<Dish> menu = Dish.menu();

        // Garbage Variable
        List<Dish> lowCaloricDishes = new ArrayList<>();

        for (Dish dish : menu) {
            if (dish.getCalories() < 400) {
                lowCaloricDishes.add(dish);
            }
        }

        Collections.sort(lowCaloricDishes, new Comparator<Dish>() {
            public int compare(Dish dish1, Dish dish2) {
                return Integer.compare(dish1.getCalories(), dish2.getCalories());
            }
        });

        List<String> lowCaloricDishName = new ArrayList<>();

        for (Dish dish : lowCaloricDishes) {
            lowCaloricDishName.add(dish.getName());
        }

        for (String dishName : lowCaloricDishName) {
            log.debug("asIs.getName() = {}", dishName);
        }

    }
}
