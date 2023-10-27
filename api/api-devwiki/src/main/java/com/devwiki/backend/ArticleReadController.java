package com.devwiki.backend;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devwiki.backend.article.articleDetail.ArticleDetail;
import com.devwiki.backend.service.ArticleDetailQueryHandler;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/article/read")
public class ArticleReadController {
	private final ArticleDetailQueryHandler articleDetailQueryHandler;

	@GetMapping("/detail")
	public ArticleDetail readArticle(@RequestParam Long articleId, @RequestParam Long version) {
		return articleDetailQueryHandler.query(articleId, version);
	}

}
