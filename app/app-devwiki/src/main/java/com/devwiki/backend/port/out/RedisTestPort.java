package com.devwiki.backend.port.out;

import com.devwiki.backend.article.articleDetail.RedisTestDetail;

public interface RedisTestPort {


    public RedisTestDetail query(String title);
}
