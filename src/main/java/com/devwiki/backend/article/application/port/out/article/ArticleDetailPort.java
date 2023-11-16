package com.devwiki.backend.article.application.port.out.article;

import com.devwiki.backend.article.domain.article.articleDetail.ArticleDetail;

public interface ArticleDetailPort {
	ArticleDetail query(Long articleId, Long articleVersion);
}
