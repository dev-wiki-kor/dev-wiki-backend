package com.devwiki.backend.article.adapter.in;

import lombok.NonNull;

public record EditArticleRequest(

	@NonNull Long userId,
	@NonNull String articleType,
	@NonNull Long articleId,
	@NonNull Long parentVersion,
	@NonNull String content

) {

}
