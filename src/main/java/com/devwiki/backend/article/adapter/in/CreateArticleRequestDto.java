package com.devwiki.backend.article.adapter.in;

import java.util.Objects;

public record CreateArticleRequestDto(
	Long userId,
	String boardType,
	String sourceUrl,
	String tags,
	String title,
	String content

) {

	public CreateArticleRequestDto(
		Long userId,
		String boardType,
		String sourceUrl,
		String tags,
		String title,
		String content) {
		this.userId = Objects.requireNonNull(userId);
		this.boardType = Objects.requireNonNull(boardType);
		this.sourceUrl = Objects.requireNonNull(sourceUrl);
		this.tags = Objects.requireNonNull(tags);
		this.title = Objects.requireNonNull(title);
		this.content = Objects.requireNonNull(content);
	}

	public static CreateArticleRequestDto of(Long userId,
		String boardType,
		String sourceUrl,
		String tags,
		String title,
		String content) {

		return new CreateArticleRequestDto(
			userId,
			boardType,
			sourceUrl,
			tags,
			title,
			content
		);
	}
}


