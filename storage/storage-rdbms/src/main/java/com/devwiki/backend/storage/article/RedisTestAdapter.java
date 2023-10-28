package com.devwiki.backend.storage.article;

import com.devwiki.backend.article.articleDetail.RedisTestDetail;
import com.devwiki.backend.port.out.RedisTestPort;
import com.devwiki.backend.storage.article.entity.RedisTestMetadata;
import com.devwiki.backend.storage.article.repository.RedisTestMetadataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
@Primary
public class RedisTestAdapter implements RedisTestPort {

    private final static String TEST_KEY = "TestKey";
    private final RedisTestMetadataRepository redisTestMetadataRepository;

    @Override
    @Cacheable(key = "#title",value = TEST_KEY,cacheManager = "redisCacheManager")
    public RedisTestDetail query(String title) {
        return RedisTestMapper.toRedisTestDetail(redisTestMetadataRepository.findBytitle(title));
    }

    @Override
    @CacheEvict(key = "#title",value = TEST_KEY,cacheManager = "redisCacheManager")
    public RedisTestDetail updateQuery(String title) {
        RedisTestMetadata redisTestMetadata = redisTestMetadataRepository.findBytitle(title);
        redisTestMetadata.setTitle("updated title");
        redisTestMetadataRepository.save(redisTestMetadata);
        return RedisTestMapper.toRedisTestDetail(redisTestMetadata);
    }
}
