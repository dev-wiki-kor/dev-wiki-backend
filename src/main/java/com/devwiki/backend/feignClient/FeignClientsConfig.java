package com.devwiki.backend.feignClient;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;


@EnableFeignClients(basePackages = "com.devwiki.backend.feignClient")
@Configuration
public class FeignClientsConfig {
}
