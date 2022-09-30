package com.gilbert.modern.ExecuteAroundPattern;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class BufferedReaderMain {

    ClassPathResource resource = new ClassPathResource("static/data.txt");

    @EventListener(ApplicationStartedEvent.class)
    public void main() throws IOException {
        log.info("===== ExecuteAroundPattern / Lambda =====");
        String twoLines = processFile((BufferedReader br) -> br.readLine() + " " + br.readLine());

        log.debug("twoLines = " + twoLines);

    }

    public String processFile(BufferedReaderProcessor b) throws IOException {

        try (BufferedReader br = new BufferedReader(new FileReader(resource.getFile().getAbsolutePath()))) {
            return b.process(br);
        }
    }

}
