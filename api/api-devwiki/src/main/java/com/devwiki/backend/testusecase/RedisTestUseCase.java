package com.devwiki.backend.testusecase;

public interface RedisTestUseCase {


    void setValue(String key,String value);

    Object getValue(String key);
}
