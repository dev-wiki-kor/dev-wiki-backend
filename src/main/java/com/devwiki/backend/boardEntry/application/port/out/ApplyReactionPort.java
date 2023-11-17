package com.devwiki.backend.boardEntry.application.port.out;

import com.devwiki.backend.article.domain.ArticleType;

public interface ApplyReactionPort {

	void setLike(ArticleType articleType, Long articleId, Long like);

	void setDisLike(ArticleType articleType, Long articleId, Long disLike);
}
