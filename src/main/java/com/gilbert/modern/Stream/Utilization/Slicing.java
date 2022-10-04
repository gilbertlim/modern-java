package com.gilbert.modern.Stream.Utilization;

import com.gilbert.modern.Stream.Dish;
import java.util.List;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Slicing {

    @EventListener(ApplicationStartedEvent.class)
    public void main() {
        log.info("===== Stream / Utilization / Slicing =====");
        List<Dish> menu = Dish.menu();

        menu.forEach(d -> log.debug("getName : {}, getCalories : {}", d.getName(), d.getCalories()));

        // takeWhile
        List<Dish> slicedMenu1 = menu.stream().takeWhile(d -> d.getCalories() < 320).collect(Collectors.toList());
        slicedMenu1.forEach(d -> log.debug("takeWile_getName : {}", d.getName()));

        // dropWhile : 조건과 다른 것들만 리턴
        List<Dish> slicedMenu2 = menu.stream().dropWhile(d -> d.getCalories() < 320).collect(Collectors.toList());
        slicedMenu2.forEach(d -> log.debug("dropwhile_getName : {}", d.getName()));
    }
}
