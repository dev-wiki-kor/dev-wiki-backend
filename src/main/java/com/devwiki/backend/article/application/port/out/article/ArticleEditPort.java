package com.devwiki.backend.article.application.port.out.article;

import com.devwiki.backend.article.application.port.out.GeneratedVersion;
import com.devwiki.backend.article.domain.article.articleModify.ArticleEdit;

public interface ArticleEditPort {
	GeneratedVersion editArticle(ArticleEdit articleEdit);
}
