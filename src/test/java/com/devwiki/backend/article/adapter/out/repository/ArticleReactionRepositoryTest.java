package com.devwiki.backend.article.adapter.out.repository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ArticleReactionRepositoryTest {

	@Autowired
	ArticleReactionRepository articleReactionRepository;

	@Test
	@Sql(scripts = {"classpath:ArticleTestSample.sql"})
	void 리액션_jpql_정상적으로_도는지_체크() {
		assertEquals(1, articleReactionRepository.countLikes(1L));
		assertEquals(2, articleReactionRepository.countDislikes(1L));
		assertEquals(1, articleReactionRepository.countLikes(2L));
		assertEquals(0, articleReactionRepository.countDislikes(2L));
		assertEquals(1, articleReactionRepository.countDislikes(3L));
		assertEquals(1, articleReactionRepository.countLikes(4L));
	}

}