package com.devwiki.backend.article.application.service;

import org.springframework.stereotype.Service;

import com.devwiki.backend.article.application.port.in.ArticleDetailQuery;
import com.devwiki.backend.article.application.port.out.ArticleDetailPort;
import com.devwiki.backend.article.domain.article.articleDetail.ArticleDetail;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
@Transactional
public class ArticleDetailQueryHandler implements ArticleDetailQuery {

	private final ArticleDetailPort articleDetailPort;

	@Override
	public ArticleDetail query(Long articleId, Long articleVersion) {
		return articleDetailPort.query(articleId, articleVersion);
	}
}
