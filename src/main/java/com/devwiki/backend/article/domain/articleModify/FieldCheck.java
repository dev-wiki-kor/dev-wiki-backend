package com.devwiki.backend.article.domain.articleModify;

public class FieldCheck {
	public static void checkLength(String phrase, int maxLength, String message) {
		if (phrase == null || phrase.isBlank() || phrase.length() > maxLength)
			throw new RuntimeException(message);
	}
}
