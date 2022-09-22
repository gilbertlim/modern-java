package com.gilbert.modern.BehaviorParameterization;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.gilbert.modern.BehaviorParameterization.BehaviorParameterization.Color.GREEN;
import static com.gilbert.modern.BehaviorParameterization.BehaviorParameterization.Color.RED;

/*
* 아직은 어떻게 실행할 것인지 결정하지 않은 코드 블록
* 장기적 관점에서 유지보수가 쉽다.
*/

@Component
public class BehaviorParameterization {

    enum Color { RED, GREEN }

    // @EventListener(ApplicationStartedEvent.class)
    public static void filterApples() {
        List<Apple> inventory = new ArrayList<>(Arrays.asList(
                new Apple(80, "GREEN"),
                new Apple(155, "GREEN"),
                new Apple(120, "RED")
        ));

        System.out.println("inventory.size() = " + inventory.size());

        // color
        List<Apple> greenApplesWithColor = filterApplesByColor(inventory, GREEN);
        List<Apple> redApplesWithColor = filterApplesByColor(inventory, RED);
        System.out.println("greenApplesWithColor.getWeight() = " + greenApplesWithColor.get(0).getWeight());
        System.out.println("greenApplesWithColor.getWeight() = " + redApplesWithColor.get(0).getWeight());


        // weight
        List<Apple> greenApplesWithWeight = filterApplesByWeight(inventory, 120);
        System.out.println("greenApplesWithWeight.getWeight() = " + greenApplesWithWeight.get(0).getWeight());


        // color and weight
        AppleRedAndHeavyPredicate appleRedAndHeavyPredicate = new AppleRedAndHeavyPredicate();

        List<Apple> apples = filterApples(inventory, appleRedAndHeavyPredicate);

        System.out.println("apples.getColor() = " + apples.get(0).getColor());
        System.out.println("apples.getWeight() = " + apples.get(0).getWeight());


        // color and weight (anonymous class)
        List<Apple> applesAnonymous = filterApples(inventory, new ApplePredicate() {
            @Override
            public boolean test(Apple apple) {
                return RED.toString().equals(apple.getColor())
                        && apple.getWeight() > 110;
            }
        });

        System.out.println("applesAnonymous.getColor() = " + applesAnonymous.get(0).getColor());
        System.out.println("applesAnonymous.getWeight() = " + applesAnonymous.get(0).getWeight());


        // formatter
        prettyPrintApple(inventory, new AppleFancyFormatter());


        // lambda
        List<Apple> resultAnonymousLambda = filterApples(inventory, new ApplePredicate() {
            @Override
            public boolean test(Apple apple) {
                return RED.toString().equals(apple.getColor());
            }
        });

        System.out.println("resultAnonymousLambda.getColor() = " + resultAnonymousLambda.get(0).getColor());
        
        List<Apple> resultLambda = filterApples(inventory, (Apple apple) -> RED.toString().equals(apple.getColor()));
        System.out.println("resultLambda.getColor() = " + resultLambda.get(0).getColor());

        // Abstraction by List
        List<Apple> redApplesListPredicate = filter(inventory, (Apple apple) -> RED.toString().equals(apple.getColor()));
        System.out.println("redApplesListPredicate = " + redApplesListPredicate.get(0).getColor());

        List<Integer> numbers = Arrays.asList(1, 20, 3);

        List<Integer> evenNumbers = filter(numbers, (Integer i) -> i % 2 == 0);
        System.out.println("evenNumbers.get(0) = " + evenNumbers.get(0));

    }

    /* List Predicate*/
    public static <T> List<T> filter(List<T> list, ListPredicate<T> predicate) {
        List<T> result = new ArrayList<>();
        for (T e : list) {
            if (predicate.test(e)) {
                result.add(e);
            }
        }
        return result;
    }


    /*
    * formatter
    * * */

    public static void prettyPrintApple(List<Apple> inventory, AppleFormatter formatter) {
        for (Apple apple : inventory) {
            String output = formatter.accept(apple);
            System.out.println("output = " + output);
        }
    }


    /*
    * color and weight
    * * */

    public static List<Apple> filterApples(List<Apple> inventory, ApplePredicate p) {
        List<Apple> result = new ArrayList<>();

        for (Apple apple : inventory) {
            if ( p.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }


    /*
    * color
    * * */

    public static List<Apple> filterApplesByColor(List<Apple> inventory, Color color) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (apple.getColor().equals(color.toString())) {
                result.add(apple);
            }
        }
        return result;
    }

    /*
    * weight
    * * */

    public static List<Apple> filterApplesByWeight(List<Apple> inventory, int weight) {
        List<Apple> result = new ArrayList<>();

        for (Apple apple : inventory) {
            if (apple.getWeight() > weight) {
                result.add(apple);
            }
        }
        return result;
    }

}
