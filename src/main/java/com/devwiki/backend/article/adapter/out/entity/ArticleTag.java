package com.devwiki.backend.article.adapter.out.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "article_tag")
@Getter
@NoArgsConstructor
public class ArticleTag {

	@Id
	@GeneratedValue
	private Long id;

	private String tag;

	@Column(name = "article_metadata_id")
	private Long articleMetadataId;

	private ArticleTag(String tag) {
		this.tag = tag;
	}

	public static ArticleTag of(String tag) {
		return new ArticleTag(tag);
	}
}
