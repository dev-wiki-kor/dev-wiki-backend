package com.devwiki.backend.article.adapter.out;

import java.util.stream.Collectors;

import com.devwiki.backend.article.adapter.out.article.entity.ArticleVersionContent;
import com.devwiki.backend.article.adapter.out.entity.ArticleMetadata;
import com.devwiki.backend.article.domain.ArticleType;
import com.devwiki.backend.article.domain.articleDetail.ArticleDetail;

public class ArticleMapper {
	public static ArticleDetail toArticleDetail(
		ArticleMetadata articleMetadata,
		ArticleVersionContent articleVersionContent,
		long likes,
		long dislikes) {

		var metadata = ArticleDetail.ArticleMetadata.of(
			articleMetadata.getId() + "", // TODO : 태그 처리
			ArticleType.TRANSLATION,
			articleMetadata.getSourceUrl(),
			articleMetadata.getCreatedAt(),
			articleMetadata.getTags().stream().map(e->e.getTag()).collect(Collectors.toSet())
		);

		// TODO : github url 가져오기
		ArticleDetail.EditorInfo editorInfo
			= ArticleDetail.EditorInfo.of(
			"" + articleVersionContent.getEditorId(),
			"github.com/helloworld"
		);

		return ArticleDetail.of(
			metadata,
			editorInfo,
			articleMetadata.getTitle(),
			articleVersionContent.getContent(),
			articleVersionContent.getVersion(),
			likes, dislikes,
			articleVersionContent.getCreatedAt()
		);

	}
}
