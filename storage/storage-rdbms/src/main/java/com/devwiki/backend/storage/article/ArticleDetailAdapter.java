package com.devwiki.backend.storage.article;

import org.springframework.stereotype.Component;

import com.devwiki.backend.article.articleDetail.ArticleDetail;
import com.devwiki.backend.storage.article.entity.ArticleMetadata;
import com.devwiki.backend.storage.article.entity.ArticleVersionContent;
import com.devwiki.backend.storage.article.repository.ArticleMetadataRepository;
import com.devwiki.backend.storage.article.repository.ArticleReactionRepository;
import com.devwiki.backend.storage.article.repository.ArticleVersionContentRepository;
import com.devwiki.backend.port.out.ArticleDetailPort;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class ArticleDetailAdapter implements ArticleDetailPort {

	ArticleMetadataRepository articleMetadataRepository;
	ArticleReactionRepository articleReactionRepository;
	ArticleVersionContentRepository articleVersionContentRepository;

	@Override
	public ArticleDetail query(Long articleId, Long articleVersion) {

		ArticleMetadata metadata = articleMetadataRepository.findById(articleId)
			.orElseThrow(() -> new RuntimeException("No article metadata found on " + articleId));

		ArticleVersionContent content = articleVersionContentRepository.findByArticleIdAndVersion(articleId,
				articleVersion)
			.orElseThrow(() -> new RuntimeException(
				"No article version  found on  id : " + articleId + " & version : " + articleVersion));

		int likes = articleReactionRepository.countLikes(articleId, articleVersion);
		int dislikes = articleReactionRepository.countDislikes(articleId, articleVersion);

		return ArticleMapper.toArticleDetail(
			metadata, content, likes, dislikes
		);
	}
}
