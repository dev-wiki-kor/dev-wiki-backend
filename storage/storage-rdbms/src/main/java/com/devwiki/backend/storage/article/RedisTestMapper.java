package com.devwiki.backend.storage.article;

import com.devwiki.backend.article.articleDetail.RedisTestDetail;
import com.devwiki.backend.storage.article.entity.RedisTestMetadata;

public class RedisTestMapper {

    public static RedisTestDetail toRedisTestDetail(
            RedisTestMetadata redisTestMetadata
    ){
        return RedisTestDetail.of(redisTestMetadata.getTitle(), redisTestMetadata.getTeam());
    }

}
