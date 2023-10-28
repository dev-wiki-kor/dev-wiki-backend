package com.devwiki.backend.article.adapter.in;

import java.util.Objects;

public record CreateArticleResponseDto(
	ArticleCreateStatus status,
	Long articleId,
	Long versionId
) {

	enum ArticleCreateStatus {
		OKAY, FAIL;
	}

	public CreateArticleResponseDto(ArticleCreateStatus status, Long articleId, Long versionId) {
		this.status = Objects.requireNonNull(status);
		this.articleId = articleId;
		this.versionId = versionId;
	}

	public CreateArticleResponseDto of(ArticleCreateStatus status, Long articleId, Long versionId) {
		return new CreateArticleResponseDto(status, articleId, versionId);
	}
}
