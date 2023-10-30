package com.devwiki.backend.article.adapter.out;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import com.devwiki.backend.article.domain.article.ArticleType;
import com.devwiki.backend.article.domain.article.articleModify.ArticleCreation;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Import({ArticleCreateAdapter.class})
class ArticleCreateAdapterTest {

	@Autowired
	ArticleCreateAdapter articleCreateAdapter;

	@Test
	public void empty() {
		assertNotNull(articleCreateAdapter);
	}

	@Test
	void 저장_성공() {
		var articleCreation = ArticleCreation.of(
			ArticleType.TRANSLATION.name(),
			1L,
			"www.create.create",
			Set.of("tag1", "tag2"),
			"title", "content"
		);

		articleCreateAdapter.createArticle(articleCreation);
	}

}