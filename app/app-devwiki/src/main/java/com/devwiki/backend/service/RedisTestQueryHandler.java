package com.devwiki.backend.service;

import com.devwiki.backend.article.articleDetail.RedisTestDetail;
import com.devwiki.backend.port.in.articleDetailQuery.RedisTestQuery;
import com.devwiki.backend.port.out.RedisTestPort;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Transactional
public class RedisTestQueryHandler implements RedisTestQuery {

    private final RedisTestPort redisTestPort;

    @Override
    public RedisTestDetail query(String title){
        return redisTestPort.query(title);
    }

}
