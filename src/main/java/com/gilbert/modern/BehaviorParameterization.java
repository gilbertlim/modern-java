package com.gilbert.modern;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static com.gilbert.modern.BehaviorParameterization.Color.GREEN;
import static com.gilbert.modern.BehaviorParameterization.Color.RED;

/*
* 아직은 어떻게 실행할 것인지 결정하지 않은 코드 블록
* 장기적 관점에서 유지보수가 쉽다.
*/

@Component
public class BehaviorParameterization {

    enum Color { RED, GREEN }

    @EventListener(ApplicationStartedEvent.class)
    public void filterApples() {
        List<Apple> inventory = new ArrayList<>();

        Apple apple = new Apple(70, "RED");
        inventory.add(apple);
        Apple apple2 = new Apple(60, "GREEN");
        inventory.add(apple2);

        // List<Apple> inventory = Arrays.asList(
        //         new Apple(80, "green"),
        //         new Apple(155, "green"),
        //         new Apple(120, "red")
        // );

        System.out.println("inventory = " + inventory.size());

        List<Apple> greenApples = filterApplesByColor(inventory, GREEN);
        List<Apple> redApples = filterApplesByColor(inventory, RED);

        System.out.println("greenApples = " + greenApples.get(0).getWeight());
        System.out.println("greenApples = " + redApples.get(0).getWeight());
    }


    public static List<Apple> filterApplesByColor(List<Apple> inventory, Color color) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (apple.getColor().equals(color.toString())) {
                result.add(apple);
            }
        }

        return result;

    }


    @AllArgsConstructor
    @Getter
    @Setter
    public static class Apple {
        private int weight = 0;
        private String color = "";

    }
}
