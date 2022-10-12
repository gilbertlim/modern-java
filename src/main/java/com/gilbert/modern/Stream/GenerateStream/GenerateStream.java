package com.gilbert.modern.Stream.GenerateStream;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class GenerateStream {

    @EventListener(ApplicationStartedEvent.class)
    public void main() {
        log.info("===== Stream / Generate Stream =====");

        // value to stream
        Stream<String> stream = Stream.of("Modern", "Java", "In", "Action");
        stream.map(String::toUpperCase)
            .forEach(v -> log.debug("value v ={}", v));

        // empty stream
        Stream<String> emptyStream = Stream.empty();

        // nullable Stream
        Stream<Object> values = Stream.ofNullable(System.getProperty("home"));
        values.forEach(v -> log.debug("nullable v = {}", v));

        // Array to Stream
        int[] numbers = {2, 3, 5, 7, 11, 13};
        int sum = Arrays.stream(numbers).sum();
        log.debug("sum = {}", sum);

        // File to Stream
        long uniqueWords = 0;
        try (Stream<String> lines = Files.lines(Paths.get("src/main/java/com/gilbert/modern/Stream/GenerateStream/data.txt"), Charset.defaultCharset())) {
            uniqueWords = lines.flatMap(line -> Arrays.stream(line.split(" ")))
                .distinct()
                .count();
        } catch (IOException e) {

        }
        log.debug("uniqueWords = {}", uniqueWords);

        // Infinite Stream (Unbounded Stream)
        Stream.iterate(0, n -> n + 2)
            .limit(10) // 무한한 값을 출력하지 않도록 사용 권장
            .forEach(v -> log.debug("v = {}", v)); // 0, 2, 4, ...

        Stream.iterate(new int[]{0, 1}, t -> new int[]{t[1], t[0] + t[1]})
            .limit(10)
            .forEach(t -> log.debug("fibonacci = {}", t[0]));

        Stream.generate(Math::random)
            .limit(10)
            .forEach(v -> log.debug("random v = {}", v));

    }
}
