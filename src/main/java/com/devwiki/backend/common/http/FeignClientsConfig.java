package com.devwiki.backend.common.http;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;


@EnableFeignClients(basePackages = "com.devwiki.backend")
@Configuration
public class FeignClientsConfig {
}
