package com.devwiki.backend.article.adapter.out.article;

import org.springframework.stereotype.Component;

import com.devwiki.backend.aop.lock.DistributedLock;
import com.devwiki.backend.article.adapter.out.article.entity.ArticleVersionContent;
import com.devwiki.backend.article.adapter.out.article.repository.ArticleVersionContentRepository;
import com.devwiki.backend.article.application.port.out.article.ArticleEditPort;
import com.devwiki.backend.article.application.port.out.GeneratedVersion;
import com.devwiki.backend.article.domain.article.articleModify.ArticleEdit;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ArticleEditAdapter implements ArticleEditPort {

	private final ArticleVersionContentRepository articleVersionContentRepository;


	@Override
	@DistributedLock(key = "#articleEdit.getArticleType.name().concat('_').concat(#articleEdit.getArticleId())")
	public GeneratedVersion editArticle(ArticleEdit articleEdit) {

		var newVersion = articleVersionContentRepository.getLastVersion(articleEdit.getArticleId())
			.orElseThrow(() -> new RuntimeException("no article metadata exist ")) + 1;

		articleVersionContentRepository.save(ArticleVersionContent.of(
			articleEdit.getArticleId(),
			newVersion,
			articleEdit.getEditorId(),
			articleEdit.getContent()
		));

		return new GeneratedVersion(newVersion);
	}
}
