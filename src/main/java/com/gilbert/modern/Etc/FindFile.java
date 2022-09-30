package com.gilbert.modern.Etc;

import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;

// @Component
@Slf4j
public class FindFile {

    @EventListener(ApplicationStartedEvent.class)
    public void hiddenFiles() {
        log.info("===== Hiiden Files =====");

        File[] hiddenFiles = new java.io.File(".").listFiles(new FileFilter() {
            public boolean accept(java.io.File file) {
                return file.isHidden();
            }
        });

        log.debug("hiddenFiles = " + Arrays.toString(hiddenFiles));

        // Method Reference : 이 메서드를 값으로 사용해라.
        java.io.File[] hiddenFiles2 = new java.io.File(".").listFiles(java.io.File::isHidden);

        log.debug("hiddenFiles = " + Arrays.toString(hiddenFiles2));
    }
}
