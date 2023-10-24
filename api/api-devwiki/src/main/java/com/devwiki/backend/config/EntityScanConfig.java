package com.devwiki.backend.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//@EntityScan(basePackages = "com.devwiki.backend.storage")
@Configuration
@ComponentScan("com.devwiki.backend.storage")
//@EnableJpaRepositories(basePackages = "com.devwiki.backend.storage")
@EntityScan("com.devwiki.backend.storage")
public class EntityScanConfig {

	public  EntityScanConfig(){
		System.out.println("***********EntityScanConfig*************");
	}
}
