package port.out;

import article.articleDetail.ArticleDetail;

public interface ArticleDetailPort {

	public ArticleDetail query(Long articleId, Long articleVersion) ;
}
