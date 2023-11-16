package com.devwiki.backend.article.adapter.out.article.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devwiki.backend.article.adapter.out.article.entity.ArticleMetadata;

public interface ArticleMetadataRepository extends JpaRepository<ArticleMetadata, Long> {
}
