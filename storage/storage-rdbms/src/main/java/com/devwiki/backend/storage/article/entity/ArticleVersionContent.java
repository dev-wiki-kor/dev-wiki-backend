package com.devwiki.backend.storage.article.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;

@Entity
@Getter
public class ArticleVersionContent {

	@Id
	private Long id;

	private Long articleId;

	private Long version;

	private Long editorId;

	private String content;

	private LocalDateTime editedAt;



}
