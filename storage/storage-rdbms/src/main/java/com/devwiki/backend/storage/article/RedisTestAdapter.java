package com.devwiki.backend.storage.article;

import com.devwiki.backend.article.articleDetail.RedisTestDetail;
import com.devwiki.backend.port.out.RedisTestPort;
import com.devwiki.backend.storage.article.repository.RedisTestMetadataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
@Primary
public class RedisTestAdapter implements RedisTestPort {

    private final RedisTestMetadataRepository redisTestMetadataRepository;

    @Override
    public RedisTestDetail query(String title) {
        return RedisTestMapper.toRedisTestDetail(redisTestMetadataRepository.findBytitle(title));
    }
}
