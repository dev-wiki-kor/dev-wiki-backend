package com.devwiki.backend.article.adapter.out.entity;

import com.devwiki.backend.common.jpa.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Generated;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "article_modify_history")
@NoArgsConstructor
public class ArticleModifyHistory extends BaseEntity {

	public enum ModifyType {
		CREATE, EDIT, DELETE;
	}

	@Id
	@Column(name = "article_modify_history_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;

	Long userId;

	Long articleId;

	Long versionId;

	@Enumerated(EnumType.STRING)
	ModifyType modifyType;

	private ArticleModifyHistory(Long userId, Long articleId, Long versionId, ModifyType modifyType) {
		this.userId = userId;
		this.articleId = articleId;
		this.versionId = versionId;
		this.modifyType = modifyType;
	}

	public static ArticleModifyHistory of(Long userId, Long articleId, Long versionId, ModifyType modifyType) {
		return new ArticleModifyHistory(userId, articleId, versionId, modifyType);
	}

}
