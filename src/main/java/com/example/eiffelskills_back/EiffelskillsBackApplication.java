package com.example.eiffelskills_back;

import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EiffelskillsBackApplication {

	public static void main(String[] args) {
		SpringApplication.run(EiffelskillsBackApplication.class, args);
	}

	@PostConstruct
	public void init() {
		System.out.println("#### EiffelskillsBackApplication Working ####");
	}

}
/* Test*/