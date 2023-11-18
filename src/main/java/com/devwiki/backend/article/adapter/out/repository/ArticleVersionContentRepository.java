package com.devwiki.backend.article.adapter.out.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.devwiki.backend.article.adapter.out.article.entity.ArticleVersionContent;

public interface ArticleVersionContentRepository extends JpaRepository<ArticleVersionContent, Long> {

	Optional<ArticleVersionContent> findByArticleIdAndVersion(Long articleId, Long version);

	@Query("SELECT max(a.version) FROM ArticleVersionContent a where a.articleId = :articleId group by a.articleId")
	Optional<Long> getLastVersion(@Param("articleId") Long articleId);
}
