package com.devwiki.backend.article.application.port.in;

import com.devwiki.backend.article.adapter.out.entity.ArticleMetadata;

public interface ArticleCreateUsecase {
	void create(CreateArticleCommand command);
}
