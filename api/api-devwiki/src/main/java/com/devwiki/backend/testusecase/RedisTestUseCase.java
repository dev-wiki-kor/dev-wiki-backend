package com.devwiki.backend.testusecase;

import java.sql.Timestamp;

public interface RedisTestUseCase {


    void setValue(String key,String value);

    Object getValue(String key);

    void setCurrentTime(String key);

    Timestamp getTimeWithKey(String key);
}
