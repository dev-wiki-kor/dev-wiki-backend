package com.devwiki.backend.service;

import org.springframework.stereotype.Service;

import com.devwiki.backend.port.out.ArticleDetailPort;

import com.devwiki.backend.article.articleDetail.ArticleDetail;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import com.devwiki.backend.port.in.articleDetailQuery.ArticleDetailQuery;

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
