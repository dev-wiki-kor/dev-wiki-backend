package com.devwiki.backend.article.adapter.out;

import org.springframework.stereotype.Component;

import com.devwiki.backend.article.adapter.out.entity.ArticleVersionContent;
import com.devwiki.backend.article.adapter.out.repository.ArticleVersionContentRepository;
import com.devwiki.backend.article.application.port.out.ArticleEditPort;
import com.devwiki.backend.article.application.port.out.GeneratedVersion;
import com.devwiki.backend.article.domain.article.articleModify.ArticleEdit;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ArticleEditAdapter implements ArticleEditPort {

	private final ArticleVersionContentRepository articleVersionContentRepository;

	@Override
	public GeneratedVersion editArticle(ArticleEdit articleEdit) {

		Long newVersion = articleVersionContentRepository.getLastVersion(articleEdit.getArticleId())
			.orElseThrow(() -> new RuntimeException("no article metadata exist ")) + 1;

		var newContent = ArticleVersionContent.of(articleEdit.getArticleId(), 0L, articleEdit.getEditorId(),
			articleEdit.getContent());

		articleVersionContentRepository.save(ArticleVersionContent.of(
			articleEdit.getArticleId(),
			newVersion,
			articleEdit.getEditorId(),
			articleEdit.getContent()
		));

		return new GeneratedVersion(newVersion);
	}
}
