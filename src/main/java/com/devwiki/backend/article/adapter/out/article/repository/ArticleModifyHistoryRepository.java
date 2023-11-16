package com.devwiki.backend.article.adapter.out.article.repository;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.devwiki.backend.article.adapter.out.article.entity.ArticleModifyHistory;

public interface ArticleModifyHistoryRepository extends JpaRepository<ArticleModifyHistory, Long> {

	@Query("SELECT COUNT(a)\n"
		+ "FROM ArticleModifyHistory a\n"
		+ "WHERE a.articleId = :articleId\n"
		+ "AND a.userId = :userId\n"
		+ "AND a.createdAt = :since\n"
		+ "AND a.modifyType = 'EDIT'\n")
	long countEditSince(
		@Param("userId") Long userId,
		@Param("articleId") Long accountId,
		@Param("since") LocalDateTime since
	);

	@Query("SELECT COUNT(a)\n"
		+ "FROM ArticleModifyHistory a\n"
		+ "WHERE a.userId = :userId\n"
		+ "AND a.createdAt = :since\n"
		+ "AND a.modifyType = 'CREATE'\n")
	long countCreateSince(
		@Param("userId") Long userId,
		@Param("since") LocalDateTime since
	);

}
