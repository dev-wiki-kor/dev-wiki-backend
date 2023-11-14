package com.devwiki.backend.article.application.port.in.article;

import com.devwiki.backend.article.adapter.out.entity.ArticleMetadata;
import com.devwiki.backend.article.application.port.in.CreateArticleCommand;

public interface ArticleCreateUsecase {
	void create(CreateArticleCommand command);
}
