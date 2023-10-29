package com.devwiki.backend.article.adapter.in;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devwiki.backend.article.application.port.in.ArticleCreateUsecase;
import com.devwiki.backend.article.application.port.in.CreateArticleCommand;
import com.devwiki.backend.article.application.service.ArticleDetailQueryHandler;
import com.devwiki.backend.article.domain.article.articleDetail.ArticleDetail;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/article")
public class ArticleController {

	private final ArticleDetailQueryHandler articleDetailQueryHandler;

	private final ArticleCreateUsecase articleCreateUsecase;

	@GetMapping("/detail")
	public ArticleDetail readArticle(@RequestParam Long articleId, @RequestParam Long version) {
		return articleDetailQueryHandler.query(articleId, version);
	}

	@PostMapping("/create")
	public ResponseEntity createArticle(@RequestBody CreateArticleRequestDto requestDto) {

		articleCreateUsecase.create(CreateArticleCommand.of(requestDto));
		return ResponseEntity.ok("created");
	}

}
