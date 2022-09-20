package com.gilbert.modern;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;

@SpringBootApplication
public class ModernApplication {

	public static void main(String[] args) {
		SpringApplication.run(ModernApplication.class, args);

		File[] hiddenFiles = new File(".").listFiles(new FileFilter() {
			public boolean accept(File file) {
				return file.isHidden();
			}
		});

		// Method Reference : 이 메서드를 값으로 사용해라.
		File[] hiddenFiles2 = new File(".").listFiles(File::isHidden);

		System.out.println("hiddenFiles = " + Arrays.toString(hiddenFiles2));
	}



}
