package com.devwiki.backend.article.application.port.in.article;

import com.devwiki.backend.article.application.port.in.CreateEditCommand;

public interface ArticleEditUsecase {
	void edit(CreateEditCommand command);
}
