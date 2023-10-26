package com.devwiki.backend.config.redisConverter;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@ReadingConverter
@Component
@RequiredArgsConstructor
public class BytesToTimeStampConverter implements Converter<byte[], Timestamp> {

    private final Jackson2JsonRedisSerializer<Timestamp> serializer = new Jackson2JsonRedisSerializer<Timestamp>(new ObjectMapper(),Timestamp.class);

    @Override
    public Timestamp convert(byte[] source) {
        return serializer.deserialize(source);
    }
}
