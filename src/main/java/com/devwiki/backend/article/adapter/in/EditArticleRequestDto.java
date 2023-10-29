package com.devwiki.backend.article.adapter.in;

public record EditArticleRequestDto(

	Long userId,
	String articleType,
	Long articleId,
	Long parentVersion,
	String content
) {

}
