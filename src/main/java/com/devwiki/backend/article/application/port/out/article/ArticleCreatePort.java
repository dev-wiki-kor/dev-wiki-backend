package com.devwiki.backend.article.application.port.out.article;

import com.devwiki.backend.article.domain.articleModify.ArticleCreation;

public interface ArticleCreatePort {

	void createArticle(ArticleCreation articleCreation);
}
