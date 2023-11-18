package com.devwiki.backend.common.feignClient;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;


@EnableFeignClients(basePackages = "com.devwiki.backend")
@Configuration
public class FeignClientsConfig {
}
