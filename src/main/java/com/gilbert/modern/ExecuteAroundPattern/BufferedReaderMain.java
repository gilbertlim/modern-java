package com.gilbert.modern.ExecuteAroundPattern;

import lombok.Value;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@Component
public class BufferedReaderMain {

    ClassPathResource resource = new ClassPathResource("static/data.txt");

    @EventListener(ApplicationStartedEvent.class)
    public void main() throws IOException {
        String oneLine = processFile((BufferedReader br) -> br.readLine() + " " + br.readLine());

        System.out.println("oneLine = " + oneLine);

    }

    public String processFile(BufferedReaderprocessor b) throws IOException {

        try (BufferedReader br = new BufferedReader(new FileReader(resource.getFile().getAbsolutePath()))) {
            return b.process(br);
        }
    }

}
