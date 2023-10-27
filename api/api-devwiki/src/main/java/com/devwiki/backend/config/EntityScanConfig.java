package com.devwiki.backend.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EntityScan("com.devwiki.backend.storage")
public class EntityScanConfig {

	public  EntityScanConfig(){}


}
