package com.devwiki.backend.article.application.port.out;

import com.devwiki.backend.article.domain.article.articleDetail.ArticleDetail;

public interface ArticleDetailPort {

	public ArticleDetail query(Long articleId, Long articleVersion) ;
}
