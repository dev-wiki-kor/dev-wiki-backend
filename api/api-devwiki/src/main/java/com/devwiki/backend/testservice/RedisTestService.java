package com.devwiki.backend.testservice;

import com.devwiki.backend.testusecase.RedisTestUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RedisTestService implements RedisTestUseCase {

    private final RedisTemplate<String,String> redisTemplate;

    @Override
    public void setValue(String key, String value) {
        ValueOperations<String,String> values = redisTemplate.opsForValue();
        values.set(key,value);
    }

    @Override
    public Object getValue(String key) {
        ValueOperations<String,String> values = redisTemplate.opsForValue();
        return values.get(key);
    }
}
