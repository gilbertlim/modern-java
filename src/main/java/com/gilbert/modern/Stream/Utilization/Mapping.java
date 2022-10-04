package com.gilbert.modern.Stream.Utilization;

import com.gilbert.modern.Stream.Dish;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Mapping {

    @EventListener(ApplicationStartedEvent.class)
    public void main() {
        log.info("===== Stream / Utilization / Mapping =====");

        List<Dish> menu = Dish.menu();

        List<String> dishNames = menu.stream()
            .map(Dish::getName)
            .collect(Collectors.toList());

        dishNames.forEach(d -> log.debug("getName() = {}", d));

        List<String> words = Arrays.asList("Modern", "Java", "In", "Action");
        List<Integer> wordLengths = words.stream()
            .map(String::length)
            .collect(Collectors.toList());
        wordLengths.forEach(d -> log.debug("wordLength= {}", d));

        //flatMap
        List<String> hwords = Arrays.asList("Hello", "World");
        List<String> hSplitWords = hwords.stream()
            .map(w -> w.split("")) // 개별 문자 배열로 변환
            .flatMap(Arrays::stream) // 생성된 스트림을 하나의 스트림으로 평면화
            .distinct()
            .collect(Collectors.toList());

        hSplitWords.stream().forEach(d -> log.debug("hSplitwords = {}", d));
        // H
        // e
        // l
        // o
        // ...

        List<Integer> numbers1 = Arrays.asList(1, 2, 3);
        List<Integer> numbers2 = Arrays.asList(3, 4);

        List<int[]> pairs = numbers1.stream()
            .flatMap(
                i -> numbers2.stream()
                    .map(j -> new int[]{i, j})
            )
            .collect(Collectors.toList());

        pairs.forEach(d -> log.debug("pairs = {}", d));
        // 1, 3
        // 1, 4
        // ...

        List<int[]> pairs2 = numbers1.stream()
            .flatMap(
                i -> numbers2.stream()
                    .filter(j -> (i + j) % 3 == 0)
                    .map(j -> new int[]{i, j})
            )
            .collect(Collectors.toList());

        pairs2.forEach(d -> log.debug("pairs2 = {}", d));
    }
}
