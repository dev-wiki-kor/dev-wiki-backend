package com.devwiki.backend.testUtil;

import java.time.LocalDateTime;
import java.util.Set;

import com.devwiki.backend.article.domain.article.ArticleType;
import com.devwiki.backend.boardEntry.adapter.out.document.BoardEntryDocument;

import com.navercorp.fixturemonkey.ArbitraryBuilder;
import com.navercorp.fixturemonkey.FixtureMonkey;
import com.navercorp.fixturemonkey.generator.FieldReflectionArbitraryGenerator;

public class MonkeyUtil {
	public static FixtureMonkey monkey() {
		return FixtureMonkey.builder()
			.defaultGenerator(FieldReflectionArbitraryGenerator.INSTANCE)
			.build();
	}

	public static ArbitraryBuilder<BoardEntryDocument> boardEntryDocument() {
		return MonkeyUtil.monkey().giveMeBuilder(BoardEntryDocument.class)
			.setNull("id")
			.set("articleType", ArticleType.TRANSLATION)
			.set("articleId", 0L)
			.set("articleUpdatedDate", LocalDateTime.now())
			.set("articleEdittedDate", LocalDateTime.now())
			.set("editorId", 0L)
			.set("uploaderId", 0L)
			.set("version", 0L)
			.set("title", "default title")
			.set("tags", Set.of("default"))
			.set("content", "default content");
	}

}

