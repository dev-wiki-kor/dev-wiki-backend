package com.devwiki.backend.article.adapter.out.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class ArticleTag {

	@Id
	@GeneratedValue
	private Long id;

	private String tag;

	private ArticleTag(String tag) {
		this.tag = tag;
	}

	public static ArticleTag of(String tag) {
		return new ArticleTag(tag);
	}
}
