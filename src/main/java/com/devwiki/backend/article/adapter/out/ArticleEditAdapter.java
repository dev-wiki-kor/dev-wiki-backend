package com.devwiki.backend.article.adapter.out;

import java.util.List;

import org.springframework.stereotype.Component;

import com.devwiki.backend.article.adapter.out.article.entity.ArticleVersionContent;
import com.devwiki.backend.article.adapter.out.entity.ArticleMetadata;
import com.devwiki.backend.article.adapter.out.repository.ArticleMetadataRepository;
import com.devwiki.backend.article.adapter.out.repository.ArticleVersionContentRepository;
import com.devwiki.backend.article.application.port.out.GeneratedVersion;
import com.devwiki.backend.article.application.port.out.article.ArticleEditPort;
import com.devwiki.backend.article.domain.article.articleModify.ArticleEdit;
import com.devwiki.backend.common.aop.lock.DistributedLock;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@RequiredArgsConstructor
@Slf4j
public class ArticleEditAdapter implements ArticleEditPort {

	private final ArticleVersionContentRepository articleVersionContentRepository;

	private final ArticleMetadataRepository articleMetadataRepository;

	@Override
	@DistributedLock(key = "#articleEdit.getArticleType.name().concat('_').concat(#articleEdit.getArticleId())")
	public GeneratedVersion editArticle(ArticleEdit articleEdit) {

		List<ArticleMetadata> entities = articleMetadataRepository.findAll();
		var newVersion = articleVersionContentRepository.getLastVersion(articleEdit.getArticleId())
			.orElseThrow(() ->
				new RuntimeException("no article metadata exist ")
			) + 1;

		articleVersionContentRepository.save(ArticleVersionContent.of(
			articleEdit.getArticleId(),
			newVersion,
			articleEdit.getEditorId(),
			articleEdit.getContent()
		));

		return new GeneratedVersion(newVersion);
	}
}
