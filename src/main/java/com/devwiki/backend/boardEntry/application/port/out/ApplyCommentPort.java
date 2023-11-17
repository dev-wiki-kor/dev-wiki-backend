package com.devwiki.backend.boardEntry.application.port.out;

import com.devwiki.backend.article.domain.ArticleType;

public interface ApplyCommentPort {

	void setCommentCount(ArticleType articleType, Long articleId, Long commentCount);


}
