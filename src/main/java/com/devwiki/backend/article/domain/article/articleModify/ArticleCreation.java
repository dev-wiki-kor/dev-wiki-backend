package com.devwiki.backend.article.domain.article.articleModify;

import com.devwiki.backend.article.domain.article.ArticleType;

/***
 * update & create에 쓰이는 객체.
 * 역할.
 * 1) 인풋 전 validation
 * 2) editor 유저정보와
 */
public class ArticleCreation {
	ArticleType articleType;
	Long uploaderId;
	String sourceUrl;
	String tags;
	String title;
	String content;

	public void validate() {
		checkLength(title, 500,
			"title should be more than 0 letters and less than 500 letters");


		checkLength(content, 100000,
			"content should be more than 0 letters and less than 50000 letters");

		//	 TODO  : tag리스트로
		// tag size
		// each tags
		checkLength(title, 500,
			"title should be more than 0 letters and less than 500 letters");

		checkLength(sourceUrl, 2000,
			"source url should be more than 0 letters and less than 2000 letters"
			);
	}

	public void checkLength(String phrase, int maxLength, String message){
		if (phrase == null || phrase.isBlank() ||phrase.length() > maxLength)
			throw new RuntimeException(message);

	}

}
