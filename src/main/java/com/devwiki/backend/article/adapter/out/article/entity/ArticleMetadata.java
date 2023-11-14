package com.devwiki.backend.article.adapter.out.article.entity;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import com.devwiki.backend.common.jpa.BaseEntity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.FetchType;
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

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "article_metadata_id")
	private Set<ArticleTag> tags = new HashSet<>();

	private String sourceUrl;

	private boolean deleted = Boolean.FALSE; // 삭제 여부 기본값 false

	private ArticleMetadata(Long uploaderId, String title, Set<ArticleTag> tags, String sourceUrl) {
		this.id = null;
		this.uploaderId = uploaderId;
		this.title = title;
		this.tags = tags;
		this.sourceUrl = sourceUrl;
	}

	public static ArticleMetadata of(
		Long uploaderId,
		String title,
		Set<String> tags,
		String sourceUrl
	) {

		Set<ArticleTag> tagSet = tags.stream().map(ArticleTag::of).collect(Collectors.toSet());

		return new ArticleMetadata(
			Objects.requireNonNull(uploaderId),
			Objects.requireNonNull(title),
			tags == null ? new HashSet<>() : tagSet,
			Objects.requireNonNull(sourceUrl)
		);
	}

}
