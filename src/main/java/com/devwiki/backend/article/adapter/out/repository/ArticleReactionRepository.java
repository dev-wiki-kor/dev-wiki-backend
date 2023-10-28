package com.devwiki.backend.article.adapter.out.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.devwiki.backend.article.adapter.out.entity.ArticleReaction;

public interface ArticleReactionRepository extends JpaRepository<ArticleReaction, Long> {

	@Query("SELECT COUNT(a)\n"
		+ "FROM ArticleReaction a\n"
		+ "WHERE a.articleId = :articleId\n"
		+ "AND a.accountId = :accountId\n"
		+ "AND a.reaction = 'LIKE'\n")
	long countLikes(@Param("articleId") Long accountId, @Param("accountId") Long ArticleId);

	@Query("SELECT COUNT(a)\n"
		+ "FROM ArticleReaction a\n"
		+ "WHERE a.articleId = :articleId\n"
		+ "AND a.accountId = :accountId\n"
		+ "AND a.reaction = 'DISLIKE'\n")
	long countDislikes(@Param("articleId") Long accountId, @Param("accountId") Long ArticleId);
}
