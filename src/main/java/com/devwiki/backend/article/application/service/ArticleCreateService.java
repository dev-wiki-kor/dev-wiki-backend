package com.devwiki.backend.article.application.service;

import org.springframework.stereotype.Service;

import com.devwiki.backend.article.application.port.in.article.ArticleCreateUsecase;
import com.devwiki.backend.article.application.port.in.CreateArticleCommand;
import com.devwiki.backend.article.application.port.out.article.ArticleCreatePort;
import com.devwiki.backend.article.application.port.out.CountHistoryPort;
import com.devwiki.backend.article.domain.article.articleModify.ArticleCreation;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ArticleCreateService implements ArticleCreateUsecase {

	private final ArticleCreatePort articleCreatePort;

	private final CountHistoryPort countHistoryPort;

	@Transactional
	public void create(CreateArticleCommand command) {

		var creationCount = countHistoryPort.countCreate(command.uploaderId());

		if (creationCount.compareTo(50L) > 0)
			throw new RuntimeException("you can register 50 articles one day");

		var articleCreation = ArticleCreation.of(
			command.articleType(),
			command.uploaderId(),
			command.sourceUrl(),
			command.tags(),
			command.title(),
			command.content()
		);

		articleCreation.validate();

		articleCreatePort.createArticle(articleCreation);

	}

}
