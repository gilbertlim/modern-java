package com.gilbert.modern.BehaviorParameterization;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Getter
@Component
public class AppleInventory {
    List<Apple> apples;

    public AppleInventory(List<Apple> apples) {
        this.apples = Arrays.asList(
                new Apple(80, "GREEN"),
                new Apple(155, "GREEN"),
                new Apple(120, "RED"));
    }
}
