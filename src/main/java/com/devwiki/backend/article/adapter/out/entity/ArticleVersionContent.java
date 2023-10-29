package com.devwiki.backend.article.adapter.out.entity;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import com.devwiki.backend.common.jpa.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
<<<<<<< HEAD
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Generated;
=======
import jakarta.persistence.Id;
import jakarta.persistence.Table;
>>>>>>> develop
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "article_version_content")
@SQLDelete(sql = "UPDATE article_version_content SET deleted = true WHERE article_version_content_id = ?")
@Where(clause = "deleted = false")
@NoArgsConstructor
public class ArticleVersionContent extends BaseEntity {

	@Id
	@Column(name = "article_version_content_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Long id;

	private Long articleId;

	private Long version;

	private Long editorId;

	private String content;

	private boolean deleted = Boolean.FALSE; // 삭제 여부 기본값 false


	private ArticleVersionContent(Long articleId, Long version, Long editorId, String content) {
		this.articleId = articleId;
		this.version = version;
		this.editorId = editorId;
		this.content = content;
	}

	public static ArticleVersionContent of(Long articleId, Long version, Long editorId, String content) {
		return new ArticleVersionContent(
			articleId,
			version,
			editorId,
			content
		);
	}
}
