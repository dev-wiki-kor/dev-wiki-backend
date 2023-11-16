package com.devwiki.backend.article.adapter.out.article;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import com.devwiki.backend.article.adapter.out.article.repository.ArticleModifyHistoryRepository;
import com.devwiki.backend.article.application.port.out.CountHistoryPort;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CountHistoryAdapter implements CountHistoryPort {

	private final ArticleModifyHistoryRepository articleModifyHistoryRepository;

	@Override
	public Long countCreate(Long userId) {
		return articleModifyHistoryRepository.countCreateSince(userId,
			LocalDateTime.now().minusDays(1)
		);
	}

	@Override
	public Long countEdit(Long userId, Long articleId) {
		return articleModifyHistoryRepository.countEditSince(
			userId, articleId, LocalDateTime.now().minusDays(1)
		);
	}
}
