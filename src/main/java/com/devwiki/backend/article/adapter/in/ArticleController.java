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
	public ResponseEntity createArticle(@RequestBody CreateArticleRequestDto requestDto) {

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
	public ResponseEntity editArticle(@RequestBody EditArticleRequestDto editArticleRequestDto) {

		articleEditUsecase.edit(CreateEditCommand.of(
			editArticleRequestDto.articleType(),
			editArticleRequestDto.userId(),
			editArticleRequestDto.articleId(),
			editArticleRequestDto.parentVersion(),
			editArticleRequestDto.content()
		));

		return ResponseEntity.ok("editted : ");
	}
}
