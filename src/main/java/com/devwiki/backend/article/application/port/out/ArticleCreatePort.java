package com.devwiki.backend.article.application.port.out;

import com.devwiki.backend.article.domain.article.articleModify.ArticleCreation;

public interface ArticleCreatePort {

	void createArticle(ArticleCreation articleCreation);
}
