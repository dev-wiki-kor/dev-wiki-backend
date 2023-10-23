package com.devwiki.backend.article.articleDetail;

import java.time.LocalDateTime;
import java.util.List;

import com.devwiki.backend.article.ArticleType;

import lombok.AllArgsConstructor;
import lombok.Getter;

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
	public static class EditorInfo {

		String editor;

		String editorGithubUrl;
	}

	@AllArgsConstructor(staticName = "of")
	public static class ArticleMetadata {

		String uploader;

		ArticleType articleType;

		String sourceUrl;

		LocalDateTime uploadedAt;

		List<String> tags;
	}
}
