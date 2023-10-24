package com.devwiki.backend.storage.article.entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;

@Entity
@Getter
public class ArticleMetadata {

	@Id
	private Long id;

	private Long uploaderId;

	private String title;

	private String tags;

	private String sourceUrl;

	private LocalDateTime createdAt;

}
