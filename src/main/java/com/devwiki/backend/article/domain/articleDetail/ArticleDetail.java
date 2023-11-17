package com.devwiki.backend.article.domain.articleDetail;

import java.time.LocalDateTime;
import java.util.Set;

import com.devwiki.backend.article.domain.ArticleType;

import lombok.AllArgsConstructor;
import lombok.Getter;

/***
 * 단건 조회에 사용되는 애그리거트
 */
@Getter
@AllArgsConstructor(staticName = "of")
public class ArticleDetail {

	ArticleMetadata articleMetadata;

	EditorInfo editorInfo;

	String title;

	String article;

	Long version;

	Long likes;

	Long dislikes;

	LocalDateTime editedAt;

	@AllArgsConstructor(staticName = "of")
	@Getter
	public static class EditorInfo {

		String editor;

		String editorGithubUrl;
	}

	@AllArgsConstructor(staticName = "of")
	@Getter
	public static class ArticleMetadata {

		String uploader;

		ArticleType articleType;

		String sourceUrl;

		LocalDateTime uploadedAt;

		Set<String> tags;
	}
}
