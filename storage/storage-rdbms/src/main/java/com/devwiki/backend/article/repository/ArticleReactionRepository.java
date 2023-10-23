package com.devwiki.backend.article.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devwiki.backend.article.entity.ArticleReaction;

public interface ArticleReactionRepository extends JpaRepository<ArticleReaction, Long> {

	@Query("SELECT COUNT(a)\n"
		+ "FROM ArticleReaction a\n"
		+ "WHERE a.ArticleId = :articleId\n"
		+ "AND a.AccountId = :accountId\n"
		+ "AND a.reaction = 'LIKE'\n")
	Integer countLikes(Long accountId, Long ArticleId);

	@Query("SELECT COUNT(a)\n"
		+ "FROM ArticleReaction a\n"
		+ "WHERE a.ArticleId = :articleId\n"
		+ "AND a.AccountId = :accountId\n"
		+ "AND a.reaction = 'DISLIKE'\n")
	Integer countDislikes(Long accountId, Long ArticleId);
}
