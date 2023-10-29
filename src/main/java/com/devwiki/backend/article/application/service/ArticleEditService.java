package com.devwiki.backend.article.application.service;

import org.springframework.stereotype.Service;

import com.devwiki.backend.article.adapter.out.entity.ArticleModifyHistory;
import com.devwiki.backend.article.adapter.out.repository.ArticleModifyHistoryRepository;
import com.devwiki.backend.article.application.port.in.ArticleEditUsecase;
import com.devwiki.backend.article.application.port.in.CreateEditCommand;
import com.devwiki.backend.article.application.port.out.ArticleEditPort;
import com.devwiki.backend.article.application.port.out.CountHistoryPort;
import com.devwiki.backend.article.domain.article.articleModify.ArticleEdit;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ArticleEditService implements ArticleEditUsecase {

	private final CountHistoryPort countHistoryPort;

	private final ArticleEditPort articleEditPort;

	private final ArticleModifyHistoryRepository articleModifyHistoryRepository;

	@Override
	@Transactional
	public void edit(CreateEditCommand command) {

		var updateCount = countHistoryPort.countEdit(command.editorId(), command.articleId());

		if (updateCount >= 20)
			throw new RuntimeException("you can not update 20 document in 24 hours");

		var articleEdit = ArticleEdit.of(
			command.articleType(),
			command.editorId(),
			command.articleId(),
			command.parentVersion(),
			command.content()
		);

		articleEdit.validate();

		var version = articleEditPort.editArticle(articleEdit);

		articleModifyHistoryRepository.save(
			ArticleModifyHistory.of(
				articleEdit.getEditorId(),
				articleEdit.getArticleId(),
				version.version(),
				ArticleModifyHistory.ModifyType.EDIT)
		);
	}
}
