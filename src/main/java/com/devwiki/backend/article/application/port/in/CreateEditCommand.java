package com.devwiki.backend.article.application.port.in;

public record CreateEditCommand(

	String articleType,
	Long editorId,
	Long articleId,
	Long parentVersion,
	String content

) {

	public CreateEditCommand(String articleType, Long editorId, Long articleId, Long parentVersion, String content) {
		this.articleType = articleType;
		this.editorId = editorId;
		this.articleId = articleId;
		this.parentVersion = parentVersion;
		this.content = content;
	}

	public static CreateEditCommand of(String articleType, Long editorId, Long articleId, Long parentVersion,
		String content) {
		return new CreateEditCommand(articleType, editorId, articleId, parentVersion, content);
	}
}
