package com.devwiki.backend;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import com.devwiki.backend.article.articleDetail.ArticleDetail;
import com.devwiki.backend.service.ArticleDetailQueryHandler;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ArticleReadController {
	private final ArticleDetailQueryHandler articleDetailQueryHandler;

	public ArticleDetail readArticle(Long articleId, Long version){
		return articleDetailQueryHandler.query(articleId, version);
	}

}
