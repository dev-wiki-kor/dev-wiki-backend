package com.devwiki.backend.port.out;

import com.devwiki.backend.article.articleDetail.ArticleDetail;

public interface ArticleDetailPort {

	public ArticleDetail query(Long articleId, Long articleVersion) ;
}
