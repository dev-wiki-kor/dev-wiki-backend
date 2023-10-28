package com.devwiki.backend.article.adapter.out;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.devwiki.backend.article.adapter.out.entity.ArticleMetadata;
import com.devwiki.backend.article.adapter.out.entity.ArticleVersionContent;
import com.devwiki.backend.article.adapter.out.repository.ArticleMetadataRepository;
import com.devwiki.backend.article.adapter.out.repository.ArticleReactionRepository;
import com.devwiki.backend.article.adapter.out.repository.ArticleVersionContentRepository;
import com.devwiki.backend.article.application.port.out.ArticleDetailPort;
import com.devwiki.backend.article.domain.article.articleDetail.ArticleDetail;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
@Primary
public class ArticleDetailAdapter implements ArticleDetailPort {

	private final ArticleMetadataRepository articleMetadataRepository;
	private final ArticleReactionRepository articleReactionRepository;
	private final ArticleVersionContentRepository articleVersionContentRepository;

	@Override
	public ArticleDetail query(Long articleId, Long articleVersion) {

		ArticleMetadata metadata = articleMetadataRepository.findById(articleId)
			.orElseThrow(() -> new RuntimeException("No article metadata found on " + articleId));

		ArticleVersionContent content = articleVersionContentRepository.findByArticleIdAndVersion(articleId,
				articleVersion)
			.orElseThrow(() -> new RuntimeException(
				"No article version  found on  id : " + articleId + " & version : " + articleVersion));

		long likes = articleReactionRepository.countLikes(articleId, articleVersion);
		long dislikes = articleReactionRepository.countDislikes(articleId, articleVersion);

		return ArticleMapper.toArticleDetail(
			metadata, content, likes, dislikes
		);
	}
}
