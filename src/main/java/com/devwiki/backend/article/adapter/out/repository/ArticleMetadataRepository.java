package com.devwiki.backend.article.adapter.out.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devwiki.backend.article.adapter.out.entity.ArticleMetadata;

public interface ArticleMetadataRepository extends JpaRepository<ArticleMetadata, Long> {
}
