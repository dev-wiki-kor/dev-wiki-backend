package com.devwiki.backend.article.adapter.in;

import java.util.Objects;
import java.util.Set;

import lombok.NonNull;

public record CreateArticleRequestDto(
	@NonNull Long userId,
	@NonNull String articleType,
	String sourceUrl,
	Set tags,
	@NonNull String title,
	@NonNull String content

) {

}


