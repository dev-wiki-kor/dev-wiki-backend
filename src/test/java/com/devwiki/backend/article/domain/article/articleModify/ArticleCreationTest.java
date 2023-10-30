package com.devwiki.backend.article.domain.article.articleModify;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;

import org.junit.jupiter.api.Test;

class ArticleCreationTest {

	@Test
	void 도메인_생성_성공() {
		var articleCreation = ArticleCreation.of(
			"TRANSLATION",
			1L,
			"www.wwe.com",
			Set.of("tag1", "tag2"),
			"title",
			"content"
		);
		assertNotNull(articleCreation);
	}

	@Test
	void 도메인_생성_실패_틀린_문서타입() {
		assertThrows(RuntimeException.class, () ->
			ArticleCreation.of(
				"TRANSLATION~~~~",
				1L,
				"www.wwe.com",
				Set.of("tag1", "tag2"),
				"title",
				"content"
			));
	}
	@Test
	void 필드_검증_성공() {
		var articleCreation = goodOne();
		articleCreation.validate();
	}

	@Test
	void 필드_검증_실패() {
		assertThrows(RuntimeException.class, () -> longTitle().validate());
		assertThrows(RuntimeException.class, () -> noTitle().validate());
		assertThrows(RuntimeException.class, () -> longUrl().validate());
		assertThrows(RuntimeException.class, () -> tooManyTags().validate());
		assertThrows(RuntimeException.class, () -> oneLongTag().validate());
	}

	private ArticleCreation goodOne() {
		return ArticleCreation.of(
			"TRANSLATION",
			1L,
			"www.wwe.com",
			Set.of("tag1", "tag2"),
			"title",
			"content"
		);
	}

	private ArticleCreation longTitle() {
		return ArticleCreation.of(
			"TRANSLATION",
			1L,
			"www.wwe.com",
			Set.of("tag1", "tag2"),
			"title".repeat(2000),
			"content"
		);
	}

	private ArticleCreation noTitle() {
		return ArticleCreation.of(
			"TRANSLATION",
			1L,
			"www.wwe.com",
			Set.of("tag1", "tag2"),
			null,
			"content"
		);
	}

	private ArticleCreation longUrl() {
		return ArticleCreation.of(
			"TRANSLATION",
			1L,
			"www.wwe.com",
			Set.of("tag1", "tag2"),
			null,
			"content"
		);
	}

	private ArticleCreation tooManyTags() {
		return ArticleCreation.of(
			"TRANSLATION",
			1L,
			"www.wwe.com",
			Set.of("tag1", "tag2", "tag3", "tag4", "tag5", "tag6"),
			null,
			"content"
		);
	}

	private ArticleCreation oneLongTag() {
		return ArticleCreation.of(
			"TRANSLATION",
			1L,
			"www.wwe.com",
			Set.of("tag1".repeat(100)),
			null,
			"content"
		);
	}

}