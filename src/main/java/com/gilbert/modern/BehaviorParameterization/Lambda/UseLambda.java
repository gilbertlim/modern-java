package com.gilbert.modern.BehaviorParameterization.Lambda;

import com.gilbert.modern.BehaviorParameterization.Apple;
import com.gilbert.modern.BehaviorParameterization.ApplePredicate;
import com.gilbert.modern.BehaviorParameterization.ColorConfig.Color;
import com.gilbert.modern.BehaviorParameterization.AppleInventory;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

@Component
@RequiredArgsConstructor
public class UseLambda {
    private final AppleInventory inventory;

    @EventListener(ApplicationStartedEvent.class)
    public void main() {
        System.out.println("===== Behavior Parameterization / Lambda =====");

        // color
        List<Apple> result = filterApplesByColor(inventory.getApples(), (Apple apple) -> Color.RED.toString().equals(apple.getColor()));
        System.out.println("result.getColor() = " + result.get(0).getColor());


        // color by list
        List<Apple> redApplesListPredicate = listFilter(inventory.getApples(), (Apple apple) -> Color.RED.toString().equals(apple.getColor()));
        System.out.println("redApplesListPredicate = " + redApplesListPredicate.get(0).getColor());


        // number by list
        List<Integer> numbers = Arrays.asList(1, 20, 3);
        List<Integer> evenNumbers = listFilter(numbers, (Integer i) -> i % 2 == 0);
        System.out.println("evenNumbers.get(0) = " + evenNumbers.get(0));
    }

    /* list predicate*/
    public <T> List<T> listFilter(List<T> list, Predicate<T> p) {
        List<T> result = new ArrayList<>();
        for (T e : list) {
            if (p.test(e)) {
                result.add(e);
            }
        }

        return result;
    }

    public List<Apple> filterApplesByColor(List<Apple> inventory, ApplePredicate p) {
        List<Apple> result = new ArrayList<>();

        for (Apple apple : inventory) {
            if ( p.test(apple)) {
                result.add(apple);
            }
        }

        return result;
    }

}

