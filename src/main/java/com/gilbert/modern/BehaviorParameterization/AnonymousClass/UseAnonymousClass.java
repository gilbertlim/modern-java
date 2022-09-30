package com.gilbert.modern.BehaviorParameterization.AnonymousClass;

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

@Slf4j
@Component
@RequiredArgsConstructor
public class UseAnonymousClass {

    private final AppleInventory inventory;

    @EventListener(ApplicationStartedEvent.class)
    public void main() {
        log.info("===== Behavior Parameterization / Anonymous =====");

        List<Apple> result = filterApplesByColor(inventory.getApples(), new ApplePredicate() {
            public boolean test(Apple apple) {
                return Color.RED.toString().equals(apple.getColor());
            }
        });

        log.debug("result.getColor() = " + result.get(0).getColor());
    }

    public List<Apple> filterApplesByColor(List<Apple> inventory, ApplePredicate p) {
        List<Apple> result = new ArrayList<>();

        for (Apple apple : inventory) {
            if (p.test(apple)) {
                result.add(apple);
            }
        }

        return result;
    }
}
