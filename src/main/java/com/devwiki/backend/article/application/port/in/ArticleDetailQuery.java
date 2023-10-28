package com.devwiki.backend.article.application.port.in;

import com.devwiki.backend.article.domain.article.articleDetail.ArticleDetail;

public interface ArticleDetailQuery {
	ArticleDetail query(Long articleId, Long articleVersion);
}
