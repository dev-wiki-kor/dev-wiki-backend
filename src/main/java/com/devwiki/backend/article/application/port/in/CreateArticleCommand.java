package com.devwiki.backend.article.application.port.in;

import java.util.Set;

public record CreateArticleCommand(Long uploaderId,
								   String articleType,
								   String sourceUrl,
								   Set tags,
								   String title,
								   String content) {

	public CreateArticleCommand(Long uploaderId, String articleType, String sourceUrl, Set tags, String title,
		String content) {
		this.uploaderId = uploaderId;
		this.articleType = articleType;
		this.sourceUrl = sourceUrl;
		this.tags = tags;
		this.title = title;
		this.content = content;
	}

	public static CreateArticleCommand of(Long uploaderId, String articleType, String sourceUrl, Set tags,
		String title,
		String content) {
		return new CreateArticleCommand(uploaderId, articleType, sourceUrl, tags, title, content);
	}

}
