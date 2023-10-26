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
public class TimeStampToBytesConverter implements Converter<Timestamp,byte[]> {

    private final Jackson2JsonRedisSerializer<Timestamp> serializer = new Jackson2JsonRedisSerializer<Timestamp>(new ObjectMapper(),Timestamp.class);


    @Override
    public byte[] convert(Timestamp source) {
        return serializer.serialize(source);
    }
}
