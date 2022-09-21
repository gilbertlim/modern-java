package com.gilbert.modern;

import com.gilbert.modern.BehaviorParameterization.BehaviorParameterization;
import com.gilbert.modern.Etc.FindFile;
import com.gilbert.modern.Etc.MeaningOfThis;
import com.gilbert.modern.Lambda.Main;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;


@SpringBootApplication
public class ModernApplication {

	public static void main(String[] args) {
		SpringApplication.run(ModernApplication.class, args);

		// behavior parameterization
		BehaviorParameterization.filterApples();


		// lambda
		Main.main();


		// hidden file
		FindFile.hiddenFiles();


		// 문제
		MeaningOfThis meaningOfThis = new MeaningOfThis();
		meaningOfThis.doIt();

	}


}

