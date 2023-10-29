package com.devwiki.backend.article.domain.article.articleModify;

public class FieldCheck {
	public static void checkLength(String phrase, int maxLength, String message) {
		if (phrase == null || phrase.isBlank() || phrase.length() > maxLength)
			throw new RuntimeException(message);
	}
}
