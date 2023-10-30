package com.devwiki.backend.article.domain.article.articleModify;

import static com.devwiki.backend.article.domain.article.articleModify.FieldCheck.*;

import java.util.Set;

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
	Set<String> tags;
	String title;
	String content;

	public static ArticleCreation of(
		String articleType,
		Long uploaderId,
		String sourceUrl,
		Set<String> tags,
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

		checkLength(sourceUrl, 2000,
			"source url should be more than 0 letters and less than 2000 letters"
		);

		if (tags.size() > 5)
			throw new RuntimeException("tag list should be less than 6");

		tags.stream().forEach(
			e -> checkLength(e, 20, "tag should be more than 0 letters and less than 20 letters")
		);

	}
}
