package com.gilbert.modern.BehaviorParameterization.Vanilla;

import com.gilbert.modern.BehaviorParameterization.Apple;

public class AppleFancyFormatter implements AppleFormatter {
    @Override
    public String accept(Apple apple) {
        String characteristic = apple.getWeight() > 150 ? "heavy" : "light";

        return "A " + characteristic + " " + apple.getColor() + " apple";
    }
}
