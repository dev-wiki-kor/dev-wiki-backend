package com.devwiki.backend.article.adapter.out;

import org.springframework.stereotype.Component;

import com.devwiki.backend.article.adapter.out.entity.ArticleMetadata;
import com.devwiki.backend.article.adapter.out.entity.ArticleModifyHistory;
import com.devwiki.backend.article.adapter.out.entity.ArticleVersionContent;
import com.devwiki.backend.article.adapter.out.repository.ArticleMetadataRepository;
import com.devwiki.backend.article.adapter.out.repository.ArticleModifyHistoryRepository;
import com.devwiki.backend.article.adapter.out.repository.ArticleVersionContentRepository;
import com.devwiki.backend.article.application.port.out.ArticleCreatePort;
import com.devwiki.backend.article.domain.article.articleModify.ArticleCreation;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ArticleCreateAdapter implements ArticleCreatePort {

	private final ArticleMetadataRepository articleMetadataRepository;

	private final ArticleVersionContentRepository articleVersionContentRepository;

	private final ArticleModifyHistoryRepository articleModifyHistoryRepository;

	@Override
	public void createArticle(ArticleCreation articleCreation) {

		var metadata = articleMetadataRepository.save(ArticleMetadata.of(
			articleCreation.getUploaderId(),
			articleCreation.getTitle(),
			articleCreation.getTags(),
			articleCreation.getSourceUrl()
		));

		articleVersionContentRepository.save(ArticleVersionContent.of(
			metadata.getId(),
			0L,
			articleCreation.getUploaderId(),
			articleCreation.getContent()
		));

		articleModifyHistoryRepository.save(
			ArticleModifyHistory.of(articleCreation.getUploaderId(), metadata.getId(), 0L, ArticleModifyHistory.ModifyType.CREATE)
		);

	}
}
