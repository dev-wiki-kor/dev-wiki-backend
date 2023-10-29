package com.devwiki.backend.article.domain.article.articleModify;

import static com.devwiki.backend.article.domain.article.articleModify.FieldCheck.*;

import com.devwiki.backend.article.domain.article.ArticleType;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ArticleEdit {

	ArticleType articleType;
	Long editorId;
	Long articleId;
	Long parentVersion;
	String content;

	public static ArticleEdit of(String articleType, Long editorId, Long articleId, Long parentVersion,
		String content) {

		ArticleType type = ArticleType.fromString(articleType)
			.orElseThrow(() -> new RuntimeException("invalid article type"));

		return new ArticleEdit(type, editorId, articleId, parentVersion, content);
	}

	public void validate(){
		checkLength(content, 100000,
			"content should be more than 0 letters and less than 50000 letters");
	}
}
