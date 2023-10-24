package com.devwiki.backend.storage.article.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devwiki.backend.storage.article.entity.ArticleVersionContent;

public interface ArticleVersionContentRepository extends JpaRepository<ArticleVersionContent, Long> {

	Optional<ArticleVersionContent> findByArticleIdAndVersion(Long articleId, Long version);
}
