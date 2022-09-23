package com.gilbert.modern.BehaviorParameterization.Vanilla;

import com.gilbert.modern.BehaviorParameterization.Apple;
import com.gilbert.modern.BehaviorParameterization.ApplePredicate;
import lombok.RequiredArgsConstructor;

import static com.gilbert.modern.BehaviorParameterization.ColorConfig.Color.RED;

@RequiredArgsConstructor
public class AppleRedAndHeavyPredicate implements ApplePredicate {


    @Override
    public boolean test(Apple apple) {
        return RED.toString().equals(apple.getColor())
                && apple.getWeight() > 110;
    }
}
