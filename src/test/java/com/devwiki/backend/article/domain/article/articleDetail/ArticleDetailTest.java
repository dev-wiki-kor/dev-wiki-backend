package com.devwiki.backend.article.domain.article.articleDetail;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.Set;

import org.junit.jupiter.api.Test;

import com.devwiki.backend.article.domain.article.ArticleType;

class ArticleDetailTest {

	@Test
	void 아티클_조회_객체_생성() {
		var articleDetail = ArticleDetail.of(
			ArticleDetail.ArticleMetadata.of(
				"uploader nickname", ArticleType.TRANSLATION, "www.test.com",
				LocalDateTime.now().minusDays(3), Set.of("tag1", "tag2", "tag3")),
			ArticleDetail.EditorInfo.of(
				"editor nickname", "www.github.com/editorsrepo"),
			"this is test obj",
			"article content",
			0L,
			10L,
			3L,
			LocalDateTime.now()
		);

		assertNotNull(articleDetail);
	}
}