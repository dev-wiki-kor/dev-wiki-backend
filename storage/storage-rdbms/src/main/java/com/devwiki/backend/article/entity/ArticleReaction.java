package com.devwiki.backend.article.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;

@Entity
public class ArticleReaction {

	enum Reaction {
		LIKE, DISLIKE;
	}

	@Id
	private Long id;

	private Long accountId;

	private Long articleId;

	@Enumerated(value = EnumType.STRING)
	private Reaction reaction;

}
