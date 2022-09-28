package com.gilbert.modern.Lambda.ConstructorReference;


import com.gilbert.modern.BehaviorParameterization.Apple;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

@Component
public class ConstructorReference {

    @EventListener(ApplicationStartedEvent.class)
    public void main() {
        System.out.println("===== Constructor Reference =====");

        
        // Supplier<BlueApple> b1 = () -> new BlueApple();
        Supplier<BlueApple> ba = BlueApple::new;
        BlueApple ba1 = ba.get();
        System.out.println("ba1.getClass() = " + ba1.getClass());

        
        // Function<Integer, GreenApple> a2 = (weight) -> new GreenApple(weight);
        Function<Integer, GreenApple> ga = GreenApple::new;
        GreenApple ga1 = ga.apply(100);
        System.out.println("ga1.getWeight() = " + ga1.getWeight());

        
        List<Integer> weights = Arrays.asList(7, 3, 4, 10);
        // List<GreenApple> greenApples = map(weights, weight -> new GreenApple(weight));
        List<GreenApple> greenApples = map(weights, GreenApple::new);
        for (GreenApple gas: greenApples) {
            System.out.println("weight = " + gas.getWeight());
        }
        
        
        // BiFunction<Integer, String, Apple> a1 = (weight, color) -> new Apple(weight, color);
        BiFunction<Integer, String, Apple> a = Apple::new;
        Apple a1 = a.apply(200, "GREEN");
        System.out.println("a1.getWeight() = " + a1.getWeight());
    }

    public List<GreenApple> map(List<Integer> list, Function<Integer, GreenApple> f) {
        List<GreenApple> result = new ArrayList<>();

        for (Integer i : list) {
            result.add(f.apply(i));
        }

        return result;
    }
}
