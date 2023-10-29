package com.devwiki.backend.article.domain.article.articleModify;

import com.devwiki.backend.article.domain.article.ArticleType;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

/***
 * update & create에 쓰이는 객체.
 * 역할.
 * 1) 인풋 전 validation
 * 2) editor 유저정보와
 */

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ArticleCreation {
	ArticleType articleType;
	Long uploaderId;
	String sourceUrl;
	String tags;
	String title;
	String content;

	public static ArticleCreation of(
		String articleType,
		Long uploaderId,
		String sourceUrl,
		String tags,
		String title,
		String content) {

		ArticleType type = ArticleType.fromString(articleType)
			.orElseThrow(() -> new RuntimeException("invalid article type"));

		return new ArticleCreation(type, uploaderId, sourceUrl, tags, title, content);
	}

	public void validate() {
		checkLength(title, 500,
			"title should be more than 0 letters and less than 500 letters");

		checkLength(content, 100000,
			"content should be more than 0 letters and less than 50000 letters");

		//	 TODO  : tag리스트로
		// tag size
		// each tags
		checkLength(title, 500,
			"title should be more than 0 letters and less than 500 letters");

		checkLength(sourceUrl, 2000,
			"source url should be more than 0 letters and less than 2000 letters"
		);
	}

	public void checkLength(String phrase, int maxLength, String message) {
		if (phrase == null || phrase.isBlank() || phrase.length() > maxLength)
			throw new RuntimeException(message);

	}

}
