package com.megazone.modern.BehaviorParameterization.AnonymousClass;

import com.megazone.modern.BehaviorParameterization.Apple;
import com.megazone.modern.BehaviorParameterization.ApplePredicate;
import com.megazone.modern.BehaviorParameterization.ColorConfig.Color;
import com.megazone.modern.BehaviorParameterization.AppleInventory;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class UseAnonymousClass {
    private final AppleInventory inventory;

    @EventListener(ApplicationStartedEvent.class)
    public void main() {
        System.out.println("===== Behavior Parameterization / Anonymous =====");

        List<Apple> result = filterApplesByColor(inventory.getApples(), new ApplePredicate() {
            public boolean test(Apple apple) {
                return Color.RED.toString().equals(apple.getColor());
            }
        });

        System.out.println("result.getColor() = " + result.get(0).getColor());
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
