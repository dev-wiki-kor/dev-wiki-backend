package com.devwiki.backend.testservice;

import com.devwiki.backend.config.redisConverter.BytesToTimeStampConverter;
import com.devwiki.backend.config.redisConverter.TimeStampToBytesConverter;
import com.devwiki.backend.testusecase.RedisTestUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
@RequiredArgsConstructor
public class RedisTestService implements RedisTestUseCase {

    private final RedisTemplate<String,Object> redisTemplate;
    private final RedisTemplate<String,byte[]> redisSerializationTemplate;

    private final BytesToTimeStampConverter bytesToTimeStampConverter;
    private final TimeStampToBytesConverter timeStampToBytesConverter;

    @Override
    public void setValue(String key, String value) {
        ValueOperations<String,Object> values = redisTemplate.opsForValue();
        values.set(key,value);
    }

    @Override
    public Object getValue(String key) {
        ValueOperations<String,Object> values = redisTemplate.opsForValue();
        return values.get(key);
    }

    @Override
    public void setCurrentTime(String key) {
        ValueOperations<String,byte[]> values = redisSerializationTemplate.opsForValue();
        byte[] bytes = timeStampToBytesConverter.convert(new Timestamp(System.nanoTime()));
        values.set(key,bytes);
    }

    @Override
    public Timestamp getTimeWithKey(String key) {
        ValueOperations<String,byte[]> values = redisSerializationTemplate.opsForValue();
        return bytesToTimeStampConverter.convert(values.get(key));
    }


}
