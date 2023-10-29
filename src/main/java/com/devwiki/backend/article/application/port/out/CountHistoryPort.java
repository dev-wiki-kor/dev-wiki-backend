package com.devwiki.backend.article.application.port.out;

public interface CountHistoryPort {

	Long countCreate(Long userId);

	Long countEdit(Long userId, Long articleId);
}
