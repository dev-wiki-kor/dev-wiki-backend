package com.devwiki.backend.article.adapter.out.entity;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import com.devwiki.backend.common.jpa.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.NoArgsConstructor;

@Entity
@Table(name = "article_reaction")
@SQLDelete(sql = "UPDATE article_reaction SET deleted = true WHERE article_reaction_id = ?")
@Where(clause = "deleted = false")
@NoArgsConstructor
public class ArticleReaction extends BaseEntity {

	enum Reaction {
		LIKE, DISLIKE;
	}

	@Id
	@Column(name = "article_reaction_id")

	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Long id;

	private Long accountId;

	private Long articleId;

	@Enumerated(value = EnumType.STRING)
	private Reaction reaction;


	private boolean deleted = Boolean.FALSE; // 삭제 여부 기본값 false

}
