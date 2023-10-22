package port.in.articleDetailQuery;

import article.articleDetail.ArticleDetail;

public interface ArticleDetailQuery {
	ArticleDetail query(Long articleId, Long articleVersion);
}
