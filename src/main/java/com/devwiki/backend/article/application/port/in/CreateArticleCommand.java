package com.devwiki.backend.article.application.port.in;

import com.devwiki.backend.article.adapter.in.CreateArticleRequestDto;

public record CreateArticleCommand(Long userId,
								   String boardType,
								   String sourceUrl,
								   String tags,
								   String title,
								   String content) {

	public CreateArticleCommand(Long userId, String boardType, String sourceUrl, String tags, String title,
		String content) {
		this.userId = userId;
		this.boardType = boardType;
		this.sourceUrl = sourceUrl;
		this.tags = tags;
		this.title = title;
		this.content = content;
	}

	public CreateArticleCommand of(CreateArticleRequestDto dto) {
		return new CreateArticleCommand(
			dto.userId(),
			dto.boardType(),
			dto.sourceUrl(),
			dto.tags(),
			dto.title(),
			dto.content()
		);
	}
}
