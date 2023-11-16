package com.devwiki.backend.boardEntry.port.out;

import com.devwiki.backend.article.domain.article.ArticleType;

public interface ApplyCommentPort {

	void setCommentCount(ArticleType articleType, Long articleId, Long commentCount);


}
