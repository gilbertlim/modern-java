package com.gilbert.modern.Stream;

import java.util.Arrays;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class Dish {

    private final String name;
    private final boolean vegetarian;
    private final Integer calories;
    private final DishType dishType;

    public static List<Dish> menu() {
        return Arrays.asList(
            new Dish("season fruit", true, 120, DishType.OTHER),
            new Dish("pork", false, 800, DishType.MEAT),
            new Dish("beef", false, 700, DishType.MEAT),
            new Dish("chicken", false, 400, DishType.MEAT),
            new Dish("french", true, 530, DishType.OTHER),
            new Dish("rice", true, 350, DishType.OTHER),
            new Dish("pizza", true, 550, DishType.OTHER),
            new Dish("prawns", false, 300, DishType.MEAT),
            new Dish("salmon", false, 450, DishType.MEAT)
        );
    }
}


