package com.devwiki.backend.port.in.articleDetailQuery;

import com.devwiki.backend.article.articleDetail.ArticleDetail;

public interface ArticleDetailQuery {
	ArticleDetail query(Long articleId, Long articleVersion);
}
