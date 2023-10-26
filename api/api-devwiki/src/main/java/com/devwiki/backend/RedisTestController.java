package com.devwiki.backend;

import com.devwiki.backend.testservice.RedisTestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/test/redis")
public class RedisTestController {

    private final RedisTestService redisTestService;

    @PostMapping("/input")
    public void inputTest(@RequestParam String key,@RequestParam String value) {
        redisTestService.setValue(key,value);

    }

    @PostMapping("/input-time")
    public void inputTime(@RequestParam String key){
        redisTestService.setCurrentTime(key);
    }

    @GetMapping("output/{key}")
    public String outputTest(@PathVariable String key){
        return redisTestService.getValue(key).toString();

    }

    @GetMapping("output/time/{key}")
    public String outputTimeTest(@PathVariable String key){
        return redisTestService.getTimeWithKey(key).toString();

    }
}
