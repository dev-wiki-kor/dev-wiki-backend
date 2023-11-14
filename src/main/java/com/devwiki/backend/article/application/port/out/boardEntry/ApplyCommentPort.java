package com.devwiki.backend.article.application.port.out.boardEntry;

import com.devwiki.backend.article.domain.article.ArticleType;

public interface ApplyCommentPort {

	void setCommentCount(ArticleType articleType, Long articleId, Long commentCount);


}
