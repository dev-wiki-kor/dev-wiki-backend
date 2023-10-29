package com.devwiki.backend.article.adapter.in;

import java.util.Objects;

import lombok.NonNull;

public record CreateArticleRequestDto(
	@NonNull Long userId,
	@NonNull String articleType,
	String sourceUrl,
	String tags,
	@NonNull String title,
	@NonNull String content

) {

}


