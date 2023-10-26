package com.devwiki.backend;

import com.devwiki.backend.testservice.RedisTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootApplication
@ComponentScan("com.devwiki.backend")
@EnableCaching
public class BackendApplication {

	public static void main(String[] args) {



		System.setProperty("spring.config.name", "application-api,application-storage");
		SpringApplication.run(BackendApplication.class, args);
	}
}
