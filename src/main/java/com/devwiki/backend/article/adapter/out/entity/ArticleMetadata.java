package com.devwiki.backend.article.adapter.out.entity;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import com.devwiki.backend.common.jpa.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "article_metadata")
@SQLDelete(sql = "UPDATE article_metadata SET deleted = true WHERE article_metadata_id = ?")
@Where(clause = "deleted = false")
@NoArgsConstructor
public class ArticleMetadata extends BaseEntity {

	@Id
	@Column(name = "article_metadata_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Long uploaderId;

	private String title;

	@OneToMany
	@JoinColumn(name = "article_metadata_id")
	private Set<ArticleTag> tags = new HashSet<>();

	private String sourceUrl;

	private boolean deleted = Boolean.FALSE; // 삭제 여부 기본값 false

	private ArticleMetadata(Long uploaderId, String title, String tags, String sourceUrl) {
		this.id = null;
		this.uploaderId = uploaderId;
		this.title = title;
		this.tags = tags;
		this.sourceUrl = sourceUrl;
	}

	public static ArticleMetadata of(
		Long uploaderId,
		String title,
		String tags,
		String sourceUrl
	) {
		return new ArticleMetadata(
			Objects.requireNonNull(uploaderId),
			Objects.requireNonNull(title),
			Objects.requireNonNull(tags),
			Objects.requireNonNull(sourceUrl)
		);
	}

}
