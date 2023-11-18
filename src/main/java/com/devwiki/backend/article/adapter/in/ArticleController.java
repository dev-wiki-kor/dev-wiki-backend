package com.devwiki.backend.article.adapter.in;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devwiki.backend.article.application.port.in.article.ArticleCreateUsecase;
import com.devwiki.backend.article.application.port.in.article.ArticleDetailQuery;
import com.devwiki.backend.article.application.port.in.article.ArticleEditUsecase;
import com.devwiki.backend.article.application.port.in.CreateArticleCommand;
import com.devwiki.backend.article.application.port.in.CreateEditCommand;
import com.devwiki.backend.article.domain.article.articleDetail.ArticleDetail;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/article")
public class ArticleController {

	private final ArticleDetailQuery articleDetailQuery;

	private final ArticleCreateUsecase articleCreateUsecase;

	private final ArticleEditUsecase articleEditUsecase;

	@GetMapping("/detail")
	public ArticleDetail readArticle(@RequestParam Long articleId, @RequestParam Long version) {
		return articleDetailQuery.query(articleId, version);
	}

	@PostMapping("/create")
	public ResponseEntity createArticle(@RequestBody CreateArticleRequest requestDto) {

		articleCreateUsecase.create(CreateArticleCommand.of(
			requestDto.userId(),
			requestDto.articleType(),
			requestDto.sourceUrl(),
			requestDto.tags(),
			requestDto.title(),
			requestDto.content()
		));
		return ResponseEntity.ok("created");
	}

	@PostMapping("/edit")
	public ResponseEntity editArticle(@RequestBody EditArticleRequest editArticleRequest) {

		articleEditUsecase.edit(CreateEditCommand.of(
			editArticleRequest.articleType(),
			editArticleRequest.userId(),
			editArticleRequest.articleId(),
			editArticleRequest.parentVersion(),
			editArticleRequest.content()
		));

		return ResponseEntity.ok("editted : ");
	}
}
