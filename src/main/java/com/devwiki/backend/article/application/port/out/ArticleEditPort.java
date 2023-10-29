package com.devwiki.backend.article.application.port.out;

import com.devwiki.backend.article.domain.article.articleModify.ArticleEdit;

public interface ArticleEditPort {
	GeneratedVersion editArticle(ArticleEdit articleEdit);
}
