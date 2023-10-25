package com.devwiki.backend;

import com.devwiki.backend.testservice.RedisTestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/test/redis")
public class RedisTestContoller {

    private final RedisTestService redisTestService;

    @PostMapping("/input")
    public void inputTest(){
        redisTestService.setValue("1","Hello World");
    }

    @GetMapping("output")
    public String outputTest(){
        return redisTestService.getValue("1").toString();

    }
}
