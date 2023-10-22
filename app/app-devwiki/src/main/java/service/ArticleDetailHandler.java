package service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import article.articleDetail.ArticleDetail;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import port.in.articleDetailQuery.ArticleDetailQuery;
import port.out.ArticleDetailPort;

@RequiredArgsConstructor
@Service
@Transactional
public class ArticleDetailHandler implements ArticleDetailQuery {

	ArticleDetailPort articleDetailPort;

	@Override
	public ArticleDetail query(Long articleId, Long articleVersion) {
		return articleDetailPort.query(articleId, articleVersion);
	}
}
