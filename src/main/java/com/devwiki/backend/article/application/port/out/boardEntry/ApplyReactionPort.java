package com.devwiki.backend.article.application.port.out.boardEntry;

import com.devwiki.backend.article.domain.article.ArticleType;

public interface ApplyReactionPort {

	void setLike(ArticleType articleType, Long articleId, Long like);

	void setDisLike(ArticleType articleType, Long articleId, Long disLike);
}
