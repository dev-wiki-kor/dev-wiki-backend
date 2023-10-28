package com.devwiki.backend.article.adapter.out.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devwiki.backend.article.adapter.out.entity.ArticleVersionContent;

public interface ArticleVersionContentRepository extends JpaRepository<ArticleVersionContent, Long> {

	Optional<ArticleVersionContent> findByArticleIdAndVersion(Long articleId, Long version);
}
