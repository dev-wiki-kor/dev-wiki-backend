package com.devwiki.backend.storage.article;

import java.util.List;

import com.devwiki.backend.article.ArticleType;
import com.devwiki.backend.article.articleDetail.ArticleDetail;
import com.devwiki.backend.storage.article.entity.ArticleMetadata;
import com.devwiki.backend.storage.article.entity.ArticleVersionContent;

public class ArticleMapper {
	public static ArticleDetail toArticleDetail(
		ArticleMetadata articleMetadata,
		ArticleVersionContent articleVersionContent,
		long likes,
		long dislikes) {

		ArticleDetail.ArticleMetadata metadata = ArticleDetail.ArticleMetadata.of(
			articleMetadata.getId() + "", // TODO
			ArticleType.TRANSLATION,
			articleMetadata.getSourceUrl(),
			articleMetadata.getCreatedAt(),
			//articleMetadata.getTags()
			List.of()
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
			articleVersionContent.getEditedAt()
		);

	}
}
