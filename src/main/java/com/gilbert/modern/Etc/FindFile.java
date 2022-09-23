package com.gilbert.modern.Etc;

import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;

// @Component
public class FindFile {

    // @EventListener(ApplicationStartedEvent.class)
    public void hiddenFiles() {

        File[] hiddenFiles = new java.io.File(".").listFiles(new FileFilter() {
            public boolean accept(java.io.File file) {
                return file.isHidden();
            }
        });

        System.out.println("hiddenFiles = " + Arrays.toString(hiddenFiles));

        // Method Reference : 이 메서드를 값으로 사용해라.
        java.io.File[] hiddenFiles2 = new java.io.File(".").listFiles(java.io.File::isHidden);

        System.out.println("hiddenFiles = " + Arrays.toString(hiddenFiles2));
    }
}
