package com.gilbert.modern.ExecuteAroundPattern;

import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@Component
public class BufferedReaderMain {

    ClassPathResource resource = new ClassPathResource("static/data.txt");

    @EventListener(ApplicationStartedEvent.class)
    public void main() throws IOException {
        System.out.println("===== ExecuteAroundPattern / Lambda =====");
        String twoLines = processFile((BufferedReader br) -> br.readLine() + " " + br.readLine());

        System.out.println("twoLines = " + twoLines);

    }

    public String processFile(BufferedReaderProcessor b) throws IOException {

        try (BufferedReader br = new BufferedReader(new FileReader(resource.getFile().getAbsolutePath()))) {
            return b.process(br);
        }
    }

}
