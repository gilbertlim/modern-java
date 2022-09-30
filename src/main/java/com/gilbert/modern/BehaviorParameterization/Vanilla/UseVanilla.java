package com.gilbert.modern.BehaviorParameterization.Vanilla;

import com.gilbert.modern.BehaviorParameterization.Apple;
import com.gilbert.modern.BehaviorParameterization.AppleInventory;
import com.gilbert.modern.BehaviorParameterization.ApplePredicate;
import com.gilbert.modern.BehaviorParameterization.ColorConfig.Color;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;


/*
 * 아직은 어떻게 실행할 것인지 결정하지 않은 코드 블록
 * 장기적 관점에서 유지보수가 쉽다.
 */

@Slf4j
@Component
@RequiredArgsConstructor
public class UseVanilla {

    private final AppleInventory inventory;

    @EventListener(ApplicationStartedEvent.class)
    public void main() {
        log.info("===== Behavior Parameterization / Vanilla =====");

        log.debug("inventory.size() = " + inventory.getApples().size());

        // color with method
        List<Apple> greenApplesWithColor = filterApplesByColor(inventory.getApples(), Color.GREEN);
        List<Apple> redApplesWithColor = filterApplesByColor(inventory.getApples(), Color.RED);
        log.debug("greenApplesWithColor.getWeight() = " + greenApplesWithColor.get(0).getWeight());
        log.debug("greenApplesWithColor.getWeight() = " + redApplesWithColor.get(0).getWeight());

        // weight with method
        List<Apple> greenApplesWithWeight = filterApplesByWeight(inventory.getApples(), 120);
        log.debug("greenApplesWithWeight.getWeight() = " + greenApplesWithWeight.get(0).getWeight());

        // color and weight with interface
        AppleRedAndHeavyPredicate appleRedAndHeavyPredicate = new AppleRedAndHeavyPredicate();

        List<Apple> apples = filterApplesByColorAndWeight(inventory.getApples(), appleRedAndHeavyPredicate);

        log.debug("apples.getColor() = " + apples.get(0).getColor());
        log.debug("apples.getWeight() = " + apples.get(0).getWeight());

        // formatter
        prettyPrintApple(inventory.getApples(), new AppleFancyFormatter());

    }


    /*
     * formatter
     * * */

    public void prettyPrintApple(List<Apple> inventory, AppleFormatter formatter) {
        for (Apple apple : inventory) {
            String output = formatter.accept(apple);
            log.debug("output = " + output);
        }
    }


    /*
     * color and weight
     * * */

    public List<Apple> filterApplesByColorAndWeight(List<Apple> inventory, ApplePredicate p) {
        List<Apple> result = new ArrayList<>();

        for (Apple apple : inventory) {
            if (p.test(apple)) {
                result.add(apple);
            }
        }

        return result;
    }

    /*
     * color
     * * */

    public List<Apple> filterApplesByColor(List<Apple> inventory, Color color) {
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

    public List<Apple> filterApplesByWeight(List<Apple> inventory, int weight) {
        List<Apple> result = new ArrayList<>();

        for (Apple apple : inventory) {
            if (apple.getWeight() > weight) {
                result.add(apple);
            }
        }

        return result;
    }

}
