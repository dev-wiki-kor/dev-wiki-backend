package com.devwiki.backend.article.adapter.out.repository;

import static org.springframework.test.util.AssertionErrors.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ArticleModifyHistoryRepositoryTest {

	@Autowired
	ArticleModifyHistoryRepository articleModifyHistoryRepository;

	@Test
	@Sql(scripts = {"classpath:ArticleSampleData.sql"})
	void 생성_이력_카운트() {
		var yesterday = LocalDateTime.now().minusDays(1);

		assertEquals(null,articleModifyHistoryRepository.countCreateSince(1L, yesterday), 1L);
		assertEquals(null,articleModifyHistoryRepository.countCreateSince(100L, yesterday), 0L);

	}
}