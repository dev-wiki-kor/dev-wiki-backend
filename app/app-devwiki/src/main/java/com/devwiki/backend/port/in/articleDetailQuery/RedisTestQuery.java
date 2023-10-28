package com.devwiki.backend.port.in.articleDetailQuery;

import com.devwiki.backend.article.articleDetail.RedisTestDetail;

public interface RedisTestQuery {

    RedisTestDetail query(String title);

    RedisTestDetail updateQuery(String title);
}
