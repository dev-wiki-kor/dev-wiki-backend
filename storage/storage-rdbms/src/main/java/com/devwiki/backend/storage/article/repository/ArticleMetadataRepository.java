package com.devwiki.backend.storage.article.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devwiki.backend.storage.article.entity.ArticleMetadata;

public interface ArticleMetadataRepository extends JpaRepository<ArticleMetadata, Long> {
}
