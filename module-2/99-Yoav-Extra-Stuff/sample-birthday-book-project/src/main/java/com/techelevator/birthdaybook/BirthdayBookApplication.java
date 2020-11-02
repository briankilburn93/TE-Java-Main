package com.techelevator.birthdaybook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.techelevator.birthdaybook")
@SpringBootApplication
public class BirthdayBookApplication {

	public static void main(String[] args) {
		SpringApplication.run(BirthdayBookApplication.class, args);
	}

}
