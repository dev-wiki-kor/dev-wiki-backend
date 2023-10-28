package com.devwiki.backend.article.articleDetail;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
public class RedisTestDetail {
    String title;
    String team;
}
