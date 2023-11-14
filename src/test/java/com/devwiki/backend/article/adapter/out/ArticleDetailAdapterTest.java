package com.devwiki.backend.article.adapter.out;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.jdbc.Sql;

import com.devwiki.backend.article.adapter.out.article.ArticleDetailAdapter;
import com.devwiki.backend.article.adapter.out.article.ArticleMapper;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Import({ArticleDetailAdapter.class, ArticleMapper.class})
class ArticleDetailAdapterTest {

	@Autowired
	ArticleMapper articleMapper;

	@Autowired
	ArticleDetailAdapter articleDetailAdapter;

	@Test
	public void empty() {
		assertNotNull(articleDetailAdapter);
		assertNotNull(articleMapper);
	}

	@Test
	@Sql(scripts={"classpath:ArticleTestSample.sql"})
	void 조회_성공() {

		var articleDetail = articleDetailAdapter.query(1L, 1L);
		assertNotNull(articleDetail);
		assertEquals("This is the content of Article 1", articleDetail.getArticle());
		assertEquals("Sample Article 1", articleDetail.getTitle());
		assertEquals(1,articleDetail.getLikes());
		assertEquals(2,articleDetail.getDislikes());
		assertEquals(1,articleDetail.getVersion());
	}


	@Test
	void 조회_실패_없는_문서() {
		assertThrows(RuntimeException.class, ()->  articleDetailAdapter.query(999999999L, 1L));
	}
}