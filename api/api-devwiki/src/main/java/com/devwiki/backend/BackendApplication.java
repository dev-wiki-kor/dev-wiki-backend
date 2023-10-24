package com.devwiki.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.devwiki.backend")
public class BackendApplication {
	public static void main(String[] args) {

		System.setProperty("spring.config.name", "application-api,application-storage");
		SpringApplication.run(BackendApplication.class, args);
	}
}
