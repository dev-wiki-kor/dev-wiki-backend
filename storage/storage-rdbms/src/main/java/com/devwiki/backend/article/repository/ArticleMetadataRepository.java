package com.devwiki.backend.article.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devwiki.backend.article.entity.ArticleMetadata;

public interface ArticleMetadataRepository extends JpaRepository<ArticleMetadata, Long> {
}
